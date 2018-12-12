package interpreter.symbol.function.oneArg;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Sin extends OneArg {

    public Sin(){
        name = "sin";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.sin(arg.calc());
    }
}
