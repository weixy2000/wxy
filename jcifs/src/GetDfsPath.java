import jcifs.smb.SmbFile;

public class GetDfsPath {

	public static void main(String argv[]) throws Exception {

		SmbFile f = new SmbFile(argv[0]);
		// 获取分布式文件管理目录
		System.out.println(f.getDfsPath());

	}

}
