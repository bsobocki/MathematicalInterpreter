package interpreter.symbol.function.oneArg;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Floor extends OneArg {

    public Floor(){
        name = "floor";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.floor(arg.calc());
    }
}
