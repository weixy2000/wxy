package interpreter;

/**
 *  �����Ļ���Context���ڼ�¼����ֵ
 */
import java.util.*;

public class Context  {
    private Hashtable context = new Hashtable();
    /**
     * �洢����ֵ
     * @param name
     * @param val
     */
    public void assign(String name, boolean val) {
        context.put(name, new Boolean(val));
    }
    /**
     * ���ұ���ֵ
     * @param name
     * @return
     */
    public boolean lookUp(String name) {
        return ((Boolean)context.get(name)).booleanValue();
    }
    
    public Context() {
    }
}