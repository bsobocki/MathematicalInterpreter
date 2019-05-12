package function.symbol.function.oneArg;

import ONP_interpreter.exceptions.ONP_Exception;
import function.symbol.Symbol;

public class Sin extends OneArg {

    public Sin(Symbol arg){
        super(arg);
    }
    public Sin(){
        name = "sin";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.sin(arg.calc());
    }
}
