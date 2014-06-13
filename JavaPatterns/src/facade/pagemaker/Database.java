package facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//������ϵͳ�Ĳ�����֮һ
public class Database {

	private Database() {
	}

	/**
	 * ��ȡ��Դ�ļ�������Properties
	 * 
	 * @param dbname
	 * @return Properties
	 */
	public static Properties getProperties(String dbname) {
		String filename = "src\\facade\\pagemaker\\"+dbname + ".txt";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(filename));
		} catch (IOException e) {
			System.out.println("Warning: " + filename + " is not found.");
		}
		return prop;
	}

}