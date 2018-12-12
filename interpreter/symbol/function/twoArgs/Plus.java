package interpreter.symbol.function.twoArgs;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Plus extends TwoArgs {
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
