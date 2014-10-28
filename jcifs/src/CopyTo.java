import jcifs.smb.SmbFile;

/**
 * 文件COPY,一个位置COPY到另外一个位置
 */
public class CopyTo {
	// argv[0]，共享文件访问URL，从这个地址　smb://username:password@192.168.1.168/share/test.txt
	// argv[1]，共享文件访问URL，到这个地址　smb://username:password@192.168.1.168/share/test.txt
	public static void main(String argv[]) throws Exception {

		SmbFile from = new SmbFile(argv[0]);
		SmbFile to = new SmbFile(argv[1]);
		from.copyTo(to);
		
	}
}
