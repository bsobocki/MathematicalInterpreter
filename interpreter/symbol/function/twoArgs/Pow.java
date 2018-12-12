package interpreter.symbol.function.twoArgs;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Pow extends TwoArgs {
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
