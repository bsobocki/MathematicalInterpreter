package interpreter.symbol.function.oneArg;

import ONP_interpreter.tools.exceptions.*;
import interpreter.symbol.*;
import interpreter.symbol.function.*;

public abstract class OneArg extends Function {
    Symbol arg;
    int numOfArgs = 0;

    public OneArg() {
        super(5);
    }

    void check() throws ONP_Exception {
        if (arg==null)
            throw new ONP_ArgumentDoesNotExist();
    }

    @Override
    public int numberOfArgs() {
        return numOfArgs;
    }

    @Override
    public int missingArgs() {
        return 1 - numOfArgs;
    }

    @Override
    public void addArg(Symbol arg) throws ONP_Exception {
        if(this.arg==null)
            this.arg = arg;
        else
            throw new ONP_TooManyArguments();
    }

    @Override
    public String toString(){
        return "" + name + "( " + arg.toString() + " )";
    }
}
