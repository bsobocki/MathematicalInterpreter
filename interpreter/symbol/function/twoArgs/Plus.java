package interpreter.symbol.function.twoArgs;

import ONP_interpreter.tools.exceptions.ONP_Exception;
import interpreter.symbol.Symbol;

public class Plus extends TwoArgs {

    public Plus (Symbol a1, Symbol a2){
        super(a1,a2,3);
    }
    public Plus() {
        super(3);
        name = "+";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return arg1.calc() + arg2.calc();
    }
}
