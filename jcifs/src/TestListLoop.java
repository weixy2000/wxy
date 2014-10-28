import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;

public class TestListLoop {

	public static void main(String argv[]) throws Exception {
		if (argv.length < 2) {
			System.err.println("usage: TestListLoop <smburl> <count>");
			System.exit(0);
		}

		int count = Integer.parseInt(argv[1]);

		// 列表循环
		for (;;) {
			try {
				SmbFile f = new SmbFile(argv[0]);
				SmbFile[] list = f.listFiles();
				System.out.println("Successfully listed resource: " + list.length);
			} catch (SmbException se) {
				se.printStackTrace();
			}

			if (--count <= 0)
				break;

			Thread.sleep(1000);
		}
	}
}
