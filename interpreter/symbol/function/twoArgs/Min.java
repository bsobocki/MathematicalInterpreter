package interpreter.symbol.function.twoArgs;

import ONP_interpreter.tools.exceptions.ONP_Exception;
import interpreter.symbol.Symbol;

public class Min extends TwoArgs {

    public Min (Symbol a1, Symbol a2){
        super(a1,a2,5);
    }
    public Min() {
        super(5);
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.min(arg2.calc(), arg1.calc());
    }

    @Override
    public String toString() {
        return "min { " + arg1.toString() + " , " + arg2.toString() + " }";
    }
}
