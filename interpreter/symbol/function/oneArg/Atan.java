package interpreter.symbol.function.oneArg;

import ONP_interpreter.tools.exceptions.ONP_Exception;
import interpreter.symbol.Symbol;

public class Atan extends OneArg {
    public Atan(Symbol arg){
        super(arg);
    }
    public Atan(){
        name = "atan";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.atan(arg.calc());
    }
}
