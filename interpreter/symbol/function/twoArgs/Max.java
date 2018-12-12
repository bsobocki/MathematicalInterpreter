package interpreter.symbol.function.twoArgs;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Max extends TwoArgs {
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
