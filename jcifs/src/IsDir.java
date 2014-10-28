import jcifs.smb.SmbFile;

/**
 * 是否是目录 
 */
public class IsDir {

	public static void main(String argv[]) throws Exception {
		SmbFile f = new SmbFile(argv[0]);
		System.out.println(f.isDirectory());
	}
}
