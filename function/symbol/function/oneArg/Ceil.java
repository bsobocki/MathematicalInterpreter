package function.symbol.function.oneArg;

import ONP_interpreter.exceptions.ONP_Exception;
import function.symbol.Symbol;

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
