package function.symbol.function.oneArg;

import ONP_interpreter.exceptions.ONP_Exception;
import function.symbol.Symbol;

public class Ln extends OneArg {

    public Ln(Symbol arg){
        super(arg);
    }
    public Ln(){
        name = "ln";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.log(arg.calc());
    }
}
