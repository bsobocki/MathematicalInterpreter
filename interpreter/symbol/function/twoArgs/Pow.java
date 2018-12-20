package interpreter.symbol.function.twoArgs;

import ONP_interpreter.tools.exceptions.ONP_Exception;
import interpreter.symbol.Symbol;

public class Pow extends TwoArgs {

    public Pow (Symbol a1, Symbol a2){
        super(a1,a2,5);
    }
    public Pow() {
        super(5);
        name = "^";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.pow(arg1.calc(),arg2.calc());
    }
}
