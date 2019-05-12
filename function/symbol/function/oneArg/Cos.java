package function.symbol.function.oneArg;

import ONP_interpreter.exceptions.ONP_Exception;
import function.symbol.Symbol;

public class Cos extends OneArg {
    public Cos(Symbol arg){
        super(arg);
    }
    public Cos(){
        name = "cos";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.cos(arg.calc());
    }
}
