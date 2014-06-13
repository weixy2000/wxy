package interpreter.mypackage;

import interpreter.Context;

/**
 *  The interface of our BooleanExp Interpreter
 *  BooleanExp definition is:
 *      BooleanExp ::= VariableExp | Constant | OrExp | AndExp
 *                               | NotExp | '(' BooleanExp ')'
 *      AndExp ::= BooleanExp 'and' BooleanExp
 *      OrExp ::= BooleanExp 'or' BooleanExp
 *      NotExp ::= BooleanExp 'not' BooleanExp
 *      Constant ::= 'true' | 'false'
 *      VariableExp ::= 'A' | 'B' | ... | 'Z'
 */

public interface BooleanExp {
	/**
	 * «Û÷µ
	 * @param c
	 * @return
	 */
	public abstract boolean evaluate(Context c);
	
	public abstract BooleanExp replace(String var, BooleanExp exp);

	public abstract BooleanExp copy();
}