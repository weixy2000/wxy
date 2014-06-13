package singleton;

import singleton.mypackage.SingletonA;

/**
 *  A test for SingletonA
 */
/**
 * ����ģʽ(Singleton)������ģʽȷ��ĳһ����ֻ��һ��ʵ������������ʵ������������ϵͳ�ṩ���ʵ������ģʽ��
 * 						����ģʽֻӦ���������ġ���һʵ����������ʱ�ſ�ʹ�á�
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