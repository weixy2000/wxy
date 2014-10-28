import jcifs.smb.NtlmAuthenticator;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;

/**
 * 认证多个文件，从控制台输入用户名和密码
 */
public class AuthListFiles extends NtlmAuthenticator {
	/**
	 * 从控制台获取输入的信息
	 * @return
	 * @throws Exception
	 */
	public static String readLine() throws Exception {
		int c;
		StringBuffer sb = new StringBuffer();
		while ((c = System.in.read()) != '\n') {
			if (c == -1)
				return "";
			sb.append((char) c);
		}
		return sb.toString().trim();
	}

	/**
	 * 设置默认的认证方式
	 * @param argv
	 * @throws Exception
	 */
	public AuthListFiles(String[] argv) throws Exception {
		NtlmAuthenticator.setDefault(this);
		SmbFile file = new SmbFile(argv[0]);
		SmbFile[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.print(" " + files[i].getName());
		}
		System.out.println();
	}

	/**
	 * 重写认证方法
	 */
	@Override
	protected NtlmPasswordAuthentication getNtlmPasswordAuthentication() {
		System.out.println(getRequestingException().getMessage() + " for "
				+ getRequestingURL());
		try {
			System.out.print("username: ");
			String username = readLine();

			System.out.print("password: ");
			String password = readLine();

			if (password.length() == 0) {
				return null;
			}
			return new NtlmPasswordAuthentication(null, username, password);
		} catch (Exception e) {
		}
		return null;
	}

	public static void main(String[] argv) throws Exception {
		new AuthListFiles(argv);
	}
}
