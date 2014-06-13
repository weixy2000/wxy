package interpreter;

/**
 *
 */
import interpreter.mypackage.BooleanExp;

/**
 * ������ģʽ(Interpreter)������һ�����Ժ󣬽�����ģʽ���Զ�������ķ���һ�ֱ�ʾ����ͬʱ�ṩһ����������
 * 		�ͻ��˿���ʹ�������������������������еľ��ӡ�������ģʽ����������������һ���򵥵��ķ���ʹ��ģʽ��ƽ�����Щ��䡣
 * 		�ڽ�����ģʽ�����ᵽ��������ָ�κν����������ܹ����͵��κ���ϡ�
 * 		�ڽ�����ģʽ����Ҫ����һ�������ķ���������ĵȼ��ṹ��Ҳ����һϵ�е���Ϲ���
 * 		ÿһ�����������һ�����ͷ�����������������Ľ��͡�
 * 		�������ĵȼ��ṹ�еĶ�����κ�������϶���һ�����ԡ�  
 */
public class Test  {
    public static void main(String[] args) {
        // Test :
        //         (true and x) and (y and (not x))
        Context context = new Context();
       
        VariableExp x = new VariableExp("X");
        VariableExp y = new VariableExp("Y");
        VariableExp bTure = new VariableExp("true");
        VariableExp bFalse = new VariableExp("false");

        context.assign("true", true);
        context.assign("false", false);
        context.assign("X", false);
        context.assign("Y", true);
        
        BooleanExp expression = new AndExp(
            new AndExp(bTure, x),
            new AndExp(y, new NotExp(x))
        );
        boolean result = expression.evaluate(context);
        System.out.println("The result is:" + result);
    }
}