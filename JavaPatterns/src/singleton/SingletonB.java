package singleton;

/**
 *  A new Singleton use registry
 *  ����ʽ��̬�ࣺϵͳ����ʱ��ʼ����̬��
 *  �ص㣺�����ٶ���Կ죬������ϵͳ��Դ
 */
import java.util.*;

public class SingletonB  {
    static private Hashtable<String, SingletonB> registry = new Hashtable<String, SingletonB>();
    //static private SingletonB instance;
    
    public static void Register(String name, SingletonB aInstance) {
        registry.put(name, aInstance);
    }
    public static SingletonB GetInstance(String name) {
        return LookUp(name);
    }
    
    protected static SingletonB LookUp(String name) {
        return (SingletonB)registry.get(name);
    }
}