package interpreter;

/**
 *  上下文环境Context用于记录变量值
 */
import java.util.*;

public class Context  {
    private Hashtable context = new Hashtable();
    /**
     * 存储变量值
     * @param name
     * @param val
     */
    public void assign(String name, boolean val) {
        context.put(name, new Boolean(val));
    }
    /**
     * 查找变量值
     * @param name
     * @return
     */
    public boolean lookUp(String name) {
        return ((Boolean)context.get(name)).booleanValue();
    }
    
    public Context() {
    }
}