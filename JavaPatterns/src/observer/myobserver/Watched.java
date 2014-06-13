package observer.myobserver;

import java.util.Observable;

/**
 * ���۲����ඨ��
 * 
 * @author Τ����
 * @since Apr 23, 2012, 4:04:16 PM
 */
public class Watched extends Observable {

	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		setChanged();// ���ñ��۲����ѷ����仯
		notifyObservers(price);// ֪ͨ���й۲���
	}

}
