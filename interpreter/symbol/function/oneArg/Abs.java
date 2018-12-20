package interpreter.symbol.function.oneArg;

import ONP_interpreter.tools.exceptions.ONP_Exception;
import interpreter.symbol.Symbol;

public class Abs extends OneArg {
    public Abs(Symbol arg){
        super(arg);
    }
    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.abs(arg.calc());
    }

    @Override
    public String toString(){
        return "| " + arg.toString() + " |";
    }
}
