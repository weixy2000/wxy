package observer;

/**
 *  A test client
 */
/**
 * �۲���ģʽ(Observer)���۲���ģʽ������һ��һ�Ӷ��������ϵ���ö���۲��߶���ͬʱ����ĳһ���������
 * 						������������״̬�Ϸ����仯ʱ����֪ͨ���й۲��߶���ʹ�����ܹ��Զ������Լ���
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