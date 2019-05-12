package function.symbol.function.oneArg;

import function.symbol.*;
import function.symbol.function.*;
import ONP_interpreter.exceptions.*;

public abstract class OneArg extends Function {
    Symbol arg;
    int numOfArgs = 0;

    public OneArg() {
        super(5);
    }
    public OneArg(Symbol arg){
        super(5);
        this.arg = arg;
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

    public Symbol getArg(){
        return arg;
    }
}
