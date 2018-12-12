package interpreter.symbol.function.twoArgs;

import ONP_interpreter.tools.exceptions.*;

public class Divide extends TwoArgs {
    public Divide() {
        super(4);
        name = "/";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        if (arg2.calc()==0)
            throw new ONP_DivideByZero();
        return arg1.calc()/arg2.calc();
    }

}
