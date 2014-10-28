import jcifs.smb.SmbFile;

/**
 * 　获取共享目录可用空间
 */
public class AllocInfo {

	// argv[0]，共享目录访问URL，例如 smb://username:password@192.168.1.168/share/
	public static void main(String argv[]) throws Exception {
		SmbFile f = new SmbFile(argv[0]);
		System.out.println(f.getDiskFreeSpace());
	}
}
