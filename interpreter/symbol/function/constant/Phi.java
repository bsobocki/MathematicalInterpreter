package interpreter.symbol.function.constant;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Phi extends Constant {
    @Override
    public double calc() throws ONP_Exception {
        return ( 1 + Math.sqrt(5) ) / 2;
    }
}
