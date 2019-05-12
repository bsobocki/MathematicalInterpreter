package function.symbol.function.oneArg;

import ONP_interpreter.exceptions.ONP_Exception;
import function.symbol.Symbol;

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
