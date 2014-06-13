package observer.myobserver;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Watched watched = new Watched();
		watched.addObserver(new Watcher());//ÃÌº”π€≤Ï’ﬂ
		watched.setPrice(1000);
	}

}
