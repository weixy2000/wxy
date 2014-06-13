package interpreter;

/**
 *  A variable expression implements BooleanExp
 *  终结符表达式
 */
import interpreter.mypackage.BooleanExp;

public class VariableExp implements BooleanExp {
    private String name;
    
    public VariableExp(String _name) {
        name = _name;
    }

    public boolean evaluate(Context c) {
        return c.lookUp(name);
    }

    public BooleanExp copy() {
        return new VariableExp(name);
    }

    public BooleanExp replace(String var, BooleanExp exp) {
        if(var.equals(name)) {
            return exp.copy();
        } else {
            return new VariableExp(name);
        }
    }
    
}