package interpreter.symbol.function.constant;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Pi extends Constant {
    @Override
    public double calc() throws ONP_Exception {
        return Math.PI;
    }
}
