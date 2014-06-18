package org.extremecomponents.table.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.avalon.framework.logger.Logger;
import org.apache.fop.apps.Driver;
import org.apache.fop.apps.Options;
import org.apache.fop.messaging.MessageHandler;
import org.extremecomponents.table.core.Preferences;
import org.xml.sax.InputSource;

/**
 * Pdf视图解析器
 * @author Administrator
 *
 */
public class PdfViewResolver implements ViewResolver {
    private Logger log = null;
    private final static String USERCONFIG_LOCATION = "exportPdf.userconfigLocation";

    public void resolveView(ServletRequest request, ServletResponse response, Preferences preferences, Object viewData) throws Exception {
    	
        InputStream is = new ByteArrayInputStream(((String) viewData).getBytes("UTF-8"));

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Driver driver = new Driver(new InputSource(is), out);

        if (log == null) {
            log = new ConsoleLogger(ConsoleLogger.LEVEL_WARN);
            MessageHandler.setScreenLogger(log);
        }
        
        String userconfigLocation = preferences.getPreference(USERCONFIG_LOCATION);
        if (userconfigLocation != null) {
            InputStream input = this.getClass().getResourceAsStream(userconfigLocation);
            if (input != null) {
                new Options(input);
            }
        }
        
        driver.setLogger(log);
        driver.setRenderer(Driver.RENDER_PDF);
        
        //wxy 添加部分代码使导出的PDF支持中文字体---start
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	URL url = loader.getResource("/org/extremecomponents/table/filter/PdfViewResolver.class");//get the class's working folder   
    	if(url == null){
    		url = loader.getResource("");
    	}
    	String classPathUrl = url.toExternalForm();
    	String fileRoot = classPathUrl.substring(0, classPathUrl.lastIndexOf("WEB-INF"));
    	if(fileRoot.startsWith("zip")){
    		fileRoot = "file:///"+(fileRoot.substring(4) + "WEB-INF/"); //cut the "file:/" prefix
    	}else if(fileRoot.startsWith("file")){
    		fileRoot = "file:///"+(fileRoot.substring(6) + "WEB-INF/"); //cut the "file:/" prefix
    	}
    	InputStream opis = loader.getResourceAsStream("userConfig.xml");
    	StringBuffer tempConfigurationStrBuf = new StringBuffer();
    	byte[] buffer = new byte[4096];   
    	int len;   
    	while ((len = opis.read(buffer))!= -1){   
    			String s = new String(buffer, 0, len);
    			tempConfigurationStrBuf.append(s);
    	}   
    	String configurationStr = tempConfigurationStrBuf.toString();
    	configurationStr = configurationStr.replaceAll("@@@@@@@@@@", fileRoot);
    	ByteArrayInputStream bais = new ByteArrayInputStream(configurationStr.getBytes());
    	org.apache.fop.apps.Options options = new org.apache.fop.apps.Options();
    	options.loadUserconfiguration(bais);
        //wxy------end
    	
        driver.run();

        byte[] contents = out.toByteArray();
        response.setContentLength(contents.length);
        response.getOutputStream().write(contents);
    }
}
