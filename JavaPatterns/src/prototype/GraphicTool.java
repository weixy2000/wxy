package prototype;

/*
 *  As  a Test Client to test our pattern  
 */
import java.util.*;

import prototype.mypackage.Graphic;

/**
 * ԭ��ģʽ(Prototype)��ͨ������һ��ԭ�Ͷ�����ָ����Ҫ�����Ķ�������ͣ�Ȼ���ø������ԭ�Ͷ���ķ�������������ͬ���͵Ķ���
 * 					ԭʼģ��ģʽ����̬�����ӻ���ٲ�Ʒ�࣬��Ʒ�಻��Ҫ�ǵ����κ�����ȷ���ĵȼ��ṹ��ԭʼģ��ģʽ�������κεĵȼ��ṹ��
 * 					ȱ����ÿһ���඼�����䱸һ����¡������  
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