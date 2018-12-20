package interpreter.symbol.function.oneArg;

import ONP_interpreter.tools.exceptions.ONP_Exception;
import interpreter.symbol.Symbol;

public class Sgn extends OneArg {

    public Sgn(Symbol arg){
        super(arg);
    }
    public Sgn(){
        name = "sgn";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        if(arg.calc()>0)
            return 1;
        else if(arg.calc()==0)
            return 0;
        else
            return -1;
    }
}
