import jcifs.smb.ACE;
import jcifs.smb.SmbFile;

public class SidCacheTest {

	// Sid 缓存测试
    public static void main( String[] argv ) throws Exception {
        long t1, t2, t3;
        SmbFile file;
        ACE[] security;
        int ai;

        file = new SmbFile(argv[0]);
        t1 = System.currentTimeMillis();
        security = file.getSecurity(true);
        t2 = System.currentTimeMillis();
        security = file.getSecurity(true);
        t3 = System.currentTimeMillis();

        System.out.println("dt1=" + (t2 - t1) + ",dt2=" + (t3 - t2) + " " + ((t2 - t1) / (t3 - t2)) + "x increase");
    }
}
