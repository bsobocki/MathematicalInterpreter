package function.symbol.function.twoArgs;

import interpreter.collections.*;
import ONP_interpreter.exceptions.*;
import function.symbol.*;
import function.symbol.function.Function;
import function.symbol.operand.Variable;

public class Assign extends Function {
    Variable arg1;
    Symbol arg2;
    private int numberOfArgs;

    public Assign() {
        super(0);
    }

    /**add to set and return it*/
    public Set assign(Set set){
        check();
        set.add(arg1.getName(),arg2.calc());
        return set;
    }

    /**methods*/
    private void check() throws ONP_Exception {
        if (arg2==null || arg1==null)
            throw new ONP_ArgumentDoesNotExist();
    }

    public void addArg1(Variable arg) throws ONP_Exception{
        if(arg1==null)
            this.arg1 = arg;
        else
            throw new ONP_TooManyArguments();
    }

    @Override
    public void addArg(Symbol arg) throws ONP_Exception{
        if(arg2==null)
            this.arg2 = arg;
        else
            throw new ONP_TooManyArguments();
    }

    @Override
    public double calc() throws ONP_Exception {
        return 0;
    }

    @Override
    public int numberOfArgs() {
        return 2;
    }

    @Override
    public int missingArgs() {
        return 2 - numberOfArgs;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public String toString2() {
        return null;
    }
}
