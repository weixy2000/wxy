import jcifs.smb.SmbFile;

/**
 * 文件是否存在
 */
public class Exists {

	public static void main(String argv[]) throws Exception {

		SmbFile f = new SmbFile(argv[0]);
		if (f.exists()) {
			System.out.println(argv[0] + " exists");
		} else {
			System.out.println(argv[0] + " does not exist");
		}
	}
}
