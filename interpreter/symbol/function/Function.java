package interpreter.symbol.function;

import interpreter.Functional;
import interpreter.symbol.*;

public abstract class Function extends Symbol implements Functional {

    protected String name;

    public Function(int priority) {
        super(priority);
    }

    @Override
    public String toString2() {
        return toString() + " = " + calc();
    }
}
