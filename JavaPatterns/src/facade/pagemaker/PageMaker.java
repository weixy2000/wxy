package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//Facade构筑成系统的其他参与者的"单一窗口"
//Facade参与者对系统外部提供高级且单一的接口（API）
public class PageMaker {
	private PageMaker() {
	}

	public static void makeWelcomePage(String mailaddr, String filename) {
		try {
			Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("Welcome to " + username + "'s page!");
			writer.paragraph("欢迎来到" + username + "的网页。");
			writer.paragraph("等你来信喔！");
			writer.mailto(mailaddr, username);
			writer.close();
			System.out.println(filename + " is created for " + mailaddr + "("
					+ username + ")");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
