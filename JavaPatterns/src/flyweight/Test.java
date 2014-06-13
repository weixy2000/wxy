package flyweight;

/**
 *  A test client
 */
import java.util.*;

/**	
 * 享元模式(Flyweight)：FLYWEIGHT在拳击比赛中指最轻量级。享元模式以共享的方式高效的支持大量的细粒度对象。
 * 						享元模式能做到共享的关键是区分内蕴状态和外蕴状态。内蕴状态存储在享元内部，不会随环境的改变而有所不同。
 * 						外蕴状态是随环境的改变而改变的。外蕴状态不能影响内蕴状态，它们是相互独立的。
 * 						将可以共享的状态和不可以共享的状态从常规类中区分开来，将不可以共享的状态从类里剔除出去。
 * 						客户端不可以直接创建被共享的对象，而应当使用一个工厂对象负责创建被共享的对象。
 * 						享元模式大幅度的降低内存中对象的数量。  
 */
public class Test  {
    public static void main(String[] args) {
        int[] size = {8, 9, 10, 11, 12};
        String[] color = {"FFFFFF", "000000", "FF00FF", "CCCCCC", "111111"};
        FontFactory myFontFactory = new FontFactory();
        String aString = "A test string";
        for(int i = 0; i < aString.length(); i++) {
            int j = 0;
            j = (int)Math.floor(Math.random()*5);
            //System.out.println("j is:" + j + "---" +aString.substring(i, i+1));
            myFontFactory.GetFlyWeight(aString.substring(i, i+1)).SetFont(color[j], size[j]);
        }
        
        Hashtable myHashTable = myFontFactory.GetFactory();
        System.out.println("Hash table size is:" + myHashTable.size());
        for(int i = 0; i < aString.length(); i++) {
            ((Font)myHashTable.get(aString.substring(i, i+1))).GetFont();
        }
    }
}