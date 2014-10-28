import jcifs.smb.SmbFile;

/**
 * 设置最后修改时间
 */
public class SetTime {

	public static void main(String argv[]) throws Exception {
		SmbFile f = new SmbFile(argv[0]);
		long time = f.getLastModified();
		f.setLastModified(time + 65000); /* add 1 minute and 5 seconds */
	}
}
