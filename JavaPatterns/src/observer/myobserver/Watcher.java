package observer.myobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * �۲����ඨ��
 * 
 * @author Τ����
 * @since Apr 23, 2012, 4:03:56 PM
 */
public class Watcher implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("�۸��ѱ��޸�Ϊ:" + arg);
	}

}
