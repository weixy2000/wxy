package singleton;

import singleton.mypackage.SingletonA;

/**
 *  A test for SingletonA
 */
/**
 * 单例模式(Singleton)：单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例单例模式。
 * 						单例模式只应在有真正的“单一实例”的需求时才可使用。
 */
public class TestA  {
    public static void main(String[] args) {
        // Can not create a instance !
        //SingletonA instance1 = new SingletonA();  
        SingletonA instance2 = SingletonA.getInstance();
        if(instance2 != null) {
            instance2.setNum();
            System.out.println("i is:" + instance2.getNum());
        }
        SingletonA instance3 = SingletonA.getInstance();
        if(instance3 == null) {
            System.out.println("Can not get instance twice !");   
        }
    }
}