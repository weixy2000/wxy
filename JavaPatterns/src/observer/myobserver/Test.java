package observer.myobserver;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Watched watched = new Watched();
		watched.addObserver(new Watcher());//��ӹ۲���
		watched.setPrice(1000);
	}

}
