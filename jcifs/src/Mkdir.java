import jcifs.smb.SmbFile;

/**
 * 创建文件夹
 */
public class Mkdir {

	public static void main(String argv[]) throws Exception {
		(new SmbFile(argv[0])).mkdir();
	}
}
