package interpreter.symbol.function.oneArg;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Cos extends OneArg {
    public Cos(){
        name = "cos";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.cos(arg.calc());
    }
}
