import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

/**
 * 设置文件的属性
 */
public class SetAttrs {

	public static void main(String argv[]) throws Exception {
		if (argv.length < 2) {
			System.err.println("usage: SetAttrs <smburl> <hexval>");
			return;
		}

		SmbFile f = new SmbFile(argv[0]);
		SmbFileInputStream in = new SmbFileInputStream(f);
		int attrs = Integer.parseInt(argv[1], 16);

		f.setAttributes(attrs);
	}
}
