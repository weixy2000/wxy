import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;

/**
 * 匿名访问
 */
public class ListFilesAnon {

    public static void main( String[] argv ) throws Exception {

        for (int a = 0; a < argv.length; a++) {
            SmbFile file = new SmbFile( argv[a], NtlmPasswordAuthentication.ANONYMOUS );
            SmbFile[] files = file.listFiles();
            for( int i = 0; i < files.length; i++ ) {
                System.out.print( " " + files[i].getName() );
            }
        }
    }
}
