import jcifs.smb.DosFileFilter;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileFilter;
import jcifs.smb.SmbFilenameFilter;

/**
 * 文件过滤，包括内容大小过滤及文件名称长短过滤
 */
public class FilterFiles {

	/**
	 * 文件名称过滤
	 */
	static class ShortFilenameFilter implements SmbFilenameFilter {
		public boolean accept(SmbFile dir, String name) throws SmbException {
			return name.length() < 14;
		}
	}

	/**
	 * 文件大小过滤
	 */
	static class BigFileFilter implements SmbFileFilter {
		public boolean accept(SmbFile file) throws SmbException {
			return file.length() > 0x1FFFFL;
		}
	}

	// argv[0]，共享目录访问URL，例如 smb://username:password@192.168.1.168/share/
	public static void main(String[] argv) throws Exception {

		SmbFile file = new SmbFile(argv[0]);
		// 较大文件>0x1FFFFL
		BigFileFilter filter = new BigFileFilter();
		// 短名文件<14
		ShortFilenameFilter sfilter = new ShortFilenameFilter();
		DosFileFilter everything = new DosFileFilter("*", 0xFFFF);

		long t1 = System.currentTimeMillis();
		SmbFile[] files = file.listFiles(everything);
		long t2 = System.currentTimeMillis() - t1;

		for (int i = 0; i < files.length; i++) {
			System.out.print(" " + files[i].getName());
		}
		System.out.println();
		System.out.println(files.length + " files in " + t2 + "ms");
	}
}
