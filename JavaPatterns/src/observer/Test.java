package observer;

/**
 *  A test client
 */
/**
 * 观察者模式(Observer)：观察者模式定义了一种一队多的依赖关系，让多个观察者对象同时监听某一个主题对象。
 * 						这个主题对象在状态上发生变化时，会通知所有观察者对象，使他们能够自动更新自己。
 */
public class Test  {
    public static void main(String[] args) {
        Subject mySub = new ConcreteSubject();
        ObserverA myObserverA = new ObserverA(mySub);
        ObserverB myObserverB = new ObserverB();
        mySub.attach(myObserverA);
        mySub.attach(myObserverB);

        mySub.setState("ADD", "One --- 1");
        mySub.setState("ADD", "Tow --- 2");
        mySub.sendNotify();

        myObserverA.change("DEL", "Tow --- 2");
        myObserverA.change("ADD", "Three --- 3");
        myObserverA.change("ADD", "Four --- 4");
        myObserverA.notifySub();  
    }
}