package observer.myobserver;

import java.util.Observable;

/**
 * 被观察者类定义
 * 
 * @author 韦向阳
 * @since Apr 23, 2012, 4:04:16 PM
 */
public class Watched extends Observable {

	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		setChanged();// 设置被观察者已发生变化
		notifyObservers(price);// 通知所有观察者
	}

}
