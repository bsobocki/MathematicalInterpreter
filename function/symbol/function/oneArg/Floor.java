package function.symbol.function.oneArg;

import ONP_interpreter.exceptions.ONP_Exception;
import function.symbol.Symbol;

public class Floor extends OneArg {

    public Floor(Symbol arg){
        super(arg);
    }
    public Floor(){
        name = "floor";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.floor(arg.calc());
    }
}
