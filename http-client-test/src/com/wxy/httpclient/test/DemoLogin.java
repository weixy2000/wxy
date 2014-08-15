package com.wxy.httpclient.test;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.util.EncodingUtil;

/**
 * 使用HttpClient模拟登录新安人才网
 * <p>并在登录成功后，访问个人中心功能
 * @author xiangyang.wei
 * @since 2014-8-15下午5:28:09
 */
public class DemoLogin {
	
	static final String LOGON_SITE = "user.goodjobs.cn";
	static final int LOGON_PORT = 80;

	public DemoLogin() {
		super();
	}

	public static void main(String[] args) throws Exception {
		try {
			HttpClient client = new HttpClient();
			client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT,
					"http");
			client.getParams().setCookiePolicy(
					CookiePolicy.BROWSER_COMPATIBILITY);

			CookieSpec cookiespec = CookiePolicy.getDefaultSpec();

			// 模拟登录
			String loginURL = "http://login.goodjobs.cn/index.php/action/UserLogin";
			PostMethod httpReq = new PostMethod(loginURL);
			// 添加登录参数
			NameValuePair[] pairs = {
					new NameValuePair("memberName", "weixiangyangmail"),
					new NameValuePair("password", "test123") };
			httpReq.setRequestBody(pairs);
			client.executeMethod(httpReq);
			httpReq.releaseConnection();

			// 访问个人中心
			httpReq = new PostMethod(
					"http://user.goodjobs.cn/dispatcher.php/module/Personal/");
			int status = client.executeMethod(httpReq);
			if (status == HttpStatus.SC_OK) {
				System.out.println(EncodingUtil.getString(
						httpReq.getResponseBody(), "GBK"));
			}

			Cookie[] logoncookies = cookiespec.match(LOGON_SITE, LOGON_PORT,
					"/", false, client.getState().getCookies());
			System.out.println("Logon cookies:");
			if (logoncookies.length == 0) {
				System.out.println("None");
			} else {
				for (int i = 0; i < logoncookies.length; i++) {
					System.out.println("- " + logoncookies[i].toString());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
