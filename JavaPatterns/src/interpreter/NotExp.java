package interpreter;

import interpreter.mypackage.BooleanExp;

/**
 *  ���ս�����ʽ
 */
public class NotExp implements BooleanExp {
    private BooleanExp opernot1;
    //private BooleanExp operor2;
    
    public NotExp(BooleanExp oper1) {
        opernot1 = oper1;
    }

    public boolean evaluate(Context c) {
        return !(opernot1.evaluate(c));
    }

    public BooleanExp copy() {
        return new NotExp(opernot1.copy());
    }

    public BooleanExp replace(String var, BooleanExp exp) {
        return new NotExp(opernot1.replace(var, exp));
    }
}