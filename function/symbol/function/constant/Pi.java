package function.symbol.function.constant;

import ONP_interpreter.exceptions.ONP_Exception;

public class Pi extends Constant {
    @Override
    public double calc() throws ONP_Exception {
        return Math.PI;
    }
}
