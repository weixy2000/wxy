import jcifs.smb.ACE;
import jcifs.smb.SmbFile;

/**
 * 获取安全控制入口
 */
public class GetSecurity {

	public static void main(String[] argv) throws Exception {

		SmbFile file = new SmbFile(argv[0]);
		ACE[] security = file.getSecurity(true);

		for (int ai = 0; ai < security.length; ai++) {
			System.out.println(security[ai].toString());
		}
	}
}
