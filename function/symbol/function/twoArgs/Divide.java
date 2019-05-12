package function.symbol.function.twoArgs;

import function.symbol.*;
import ONP_interpreter.exceptions.*;

public class Divide extends TwoArgs {
    public Divide (Symbol a1, Symbol a2){
        super(a1,a2,4);
    }
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
