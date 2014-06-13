package interpreter;

/**
 *
 */
import interpreter.mypackage.BooleanExp;

/**
 * 解释器模式(Interpreter)：给定一个语言后，解释器模式可以定义出其文法的一种表示，并同时提供一个解释器。
 * 		客户端可以使用这个解释器来解释这个语言中的句子。解释器模式将描述怎样在有了一个简单的文法后，使用模式设计解释这些语句。
 * 		在解释器模式里面提到的语言是指任何解释器对象能够解释的任何组合。
 * 		在解释器模式中需要定义一个代表文法的命令类的等级结构，也就是一系列的组合规则。
 * 		每一个命令对象都有一个解释方法，代表对命令对象的解释。
 * 		命令对象的等级结构中的对象的任何排列组合都是一个语言。  
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