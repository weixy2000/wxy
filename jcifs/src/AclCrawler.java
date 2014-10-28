import java.io.IOException;
import java.net.MalformedURLException;

import jcifs.smb.ACE;
import jcifs.smb.SmbFile;

/**
 * 获取访问控制信息，访问控制迭代器
 */
public class AclCrawler {

	int maxDepth;

	/**
	 * 迭代最大深度
	 * @param maxDepth
	 */
	AclCrawler(int maxDepth) {
		this.maxDepth = maxDepth;
	}

	/**
	 * 遍历共享文件目录
	 * @param f 共享文件目录
	 * @param depth　当前深度
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	void traverse(SmbFile f, int depth) throws MalformedURLException,
			IOException {

		if (depth == 0) {
			return;
		}

		SmbFile[] l = f.listFiles();

		for (int i = 0; l != null && i < l.length; i++) {
			try {
				System.out.println(l[i]);
				ACE[] acl = l[i].getSecurity();
				for (int j = 0; j < acl.length; j++) {
					System.out.print(acl[j]);
					int a = acl[j].getAccessMask();
					if ((a & 0xFF000000) != 0) {
						if ((a & ACE.GENERIC_ALL) != 0) {
							System.out.print(" GENERIC_ALL");// 读写
						}
						if ((a & ACE.GENERIC_WRITE) != 0) {
							System.out.print(" GENERIC_WRITE");// 写
						}
						if ((a & ACE.GENERIC_READ) != 0) {
							System.out.print(" GENERIC_READ");// 读
						}
					}
					System.out.println();
				}
				if (l[i].isDirectory()) {
					traverse(l[i], depth - 1);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	// argv[0]，共享目录访问URL，例如 smb://username:password@192.168.1.168/share/
	// argv[1]，迭代最大深度
	public static void main(String[] argv) throws Exception {
		if (argv.length < 2) {
			System.err.println("usage: AclCrawler <url> <depth>");
			System.exit(1);
		}
		int depth = Integer.parseInt(argv[1]);
		AclCrawler sc = new AclCrawler(depth);
		sc.traverse(new SmbFile(argv[0]), depth);
	}
}
