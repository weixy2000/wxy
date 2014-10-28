import jcifs.smb.SmbFile;

/**
 * 获取文件的长度
 */
public class Length {

	public static void main(String argv[]) throws Exception {

		SmbFile f = new SmbFile(argv[0]);
		System.out.println(argv[0] + "'s length is " + f.length());
	}
}
