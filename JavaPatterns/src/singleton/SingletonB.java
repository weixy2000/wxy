package singleton;

/**
 *  A new Singleton use registry
 *  饿汉式单态类：系统加载时初始化单态类
 *  特点：加载速度相对快，但更耗系统资源
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