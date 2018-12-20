package interpreter.symbol.function.twoArgs;

import ONP_interpreter.tools.exceptions.ONP_Exception;
import interpreter.symbol.Symbol;

public class Log extends TwoArgs {

    public Log (Symbol a1, Symbol a2){
        super(a1,a2,5);
    }
    public Log(){
        super(5);
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.log(arg2.calc())/Math.log(arg1.calc());
    }

    @Override
    public String toString() {
        return "log "+ write("");
    }
}
