package interpreter.symbol.function.oneArg;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Ceil extends OneArg {

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.ceil(arg.calc());
    }
}
