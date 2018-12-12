package interpreter.symbol.function.twoArgs;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Log extends TwoArgs {

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
