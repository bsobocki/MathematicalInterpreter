package interpreter.symbol.function.oneArg;

import ONP_interpreter.tools.exceptions.ONP_Exception;
import interpreter.symbol.Symbol;

public class Ceil extends OneArg {

    public Ceil(Symbol arg){
        super(arg);
    }
    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.ceil(arg.calc());
    }
}
