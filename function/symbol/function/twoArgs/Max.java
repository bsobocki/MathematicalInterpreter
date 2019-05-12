package function.symbol.function.twoArgs;

import ONP_interpreter.exceptions.ONP_Exception;
import function.symbol.Symbol;

public class Max extends TwoArgs {

    public Max (Symbol a1, Symbol a2){
        super(a1,a2,5);
    }
    public Max() {
        super(5);
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.max(arg1.calc(),arg2.calc());
    }

    @Override
    public String toString() {
        return "max { " + arg1.toString() + " , " + arg2.toString() + " }";
    }
}
