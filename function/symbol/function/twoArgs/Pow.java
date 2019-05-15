package function.symbol.function.twoArgs;

import ONP_interpreter.exceptions.ONP_Exception;
import function.symbol.Symbol;

public class Pow extends TwoArgs {

    public Pow (Symbol a1, Symbol a2){
        super(a1,a2,5);
        name ="^";
    }
    public Pow() {
        super(5);
        name = "^";
    }

    @Override
    public double calc() throws ONP_Exception {
        check();
        return Math.pow(arg1.calc(),arg2.calc());
    }
}
