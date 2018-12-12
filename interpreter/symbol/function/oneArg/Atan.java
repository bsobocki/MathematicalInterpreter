package interpreter.symbol.function.oneArg;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Atan extends OneArg {

    public Atan(){
        name = "atan";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.atan(arg.calc());
    }
}
