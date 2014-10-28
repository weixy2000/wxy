import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;

public class VerifyGuest {

	public static void list(SmbFile dir) {
		try {
			long t1 = System.currentTimeMillis();
			SmbFile[] files = dir.listFiles();
			long t2 = System.currentTimeMillis() - t1;

			for (int i = 0; i < files.length; i++) {
				System.out.print(" " + files[i].getName());
			}
			System.out.println();
			System.out.println(files.length + " files in " + t2 + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] argv) throws Exception {
		list(new SmbFile("smb://miallen2/"));// 匿名用户访问
		// 实名用户访问
		list(new SmbFile("smb://miallen2/pub/", new NtlmPasswordAuthentication(
				"dom", "user", "pass")));
	}
}
