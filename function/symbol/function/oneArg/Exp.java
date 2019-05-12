package function.symbol.function.oneArg;

import ONP_interpreter.exceptions.ONP_Exception;
import function.symbol.Symbol;

public class Exp extends OneArg {

    public Exp(Symbol arg){
        super(arg);
    }
    public Exp(){
        name = "exp";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.exp(arg.calc());
    }
}
