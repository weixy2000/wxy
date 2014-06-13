package facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//构筑成系统的参与者之一
public class Database {

	private Database() {
	}

	/**
	 * 获取资源文件，返回Properties
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