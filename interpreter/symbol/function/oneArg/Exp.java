package interpreter.symbol.function.oneArg;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Exp extends OneArg {

    public Exp(){
        name = "exp";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.exp(arg.calc());
    }
}
