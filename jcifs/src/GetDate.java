import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import jcifs.smb.SmbFile;

/**
 *　获取文件最后修改日期 
 */
public class GetDate {

	// argv[0]，共享文件访问URL，例如 smb://username:password@192.168.1.168/share/test.txt
	public static void main(String argv[]) throws Exception {
		SmbFile f = new SmbFile(argv[0]);
		Date d = new Date(f.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM d, yyyy h:mm:ss a");
		sdf.setCalendar(new GregorianCalendar());
		System.out.println(sdf.format(d));
    }
}

