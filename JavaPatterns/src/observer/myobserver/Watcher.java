package observer.myobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者类定义
 * 
 * @author 韦向阳
 * @since Apr 23, 2012, 4:03:56 PM
 */
public class Watcher implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("价格已被修改为:" + arg);
	}

}
