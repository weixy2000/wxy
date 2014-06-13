package prototype;

/*
 *  As  a Test Client to test our pattern  
 */
import java.util.*;

import prototype.mypackage.Graphic;

/**
 * 原型模式(Prototype)：通过给出一个原型对象来指明所要创建的对象的类型，然后用复制这个原型对象的方法创建出更多同类型的对象。
 * 					原始模型模式允许动态的增加或减少产品类，产品类不需要非得有任何事先确定的等级结构，原始模型模式适用于任何的等级结构。
 * 					缺点是每一个类都必须配备一个克隆方法。  
 */
public class GraphicTool  {
    public GraphicTool() {
    }

    public static void main(String[] args) {
        //-----  Initial our prototype instance  ---------- 
        SymbolLoader myLoader = new SymbolLoader();
        Hashtable mySymbols = myLoader.getSymbols();

        //-----  Draw a Line  -------------------------------
        Graphic myLine = (Graphic)((Graphic)mySymbols.get("Line")).clone();
        myLine.DoSomething();
    }
}