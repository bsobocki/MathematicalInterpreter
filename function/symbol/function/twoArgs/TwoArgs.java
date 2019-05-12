package function.symbol.function.twoArgs;

import function.symbol.*;
import function.symbol.function.Function;
import ONP_interpreter.exceptions.*;
import function.symbol.operand.*;

public abstract class TwoArgs extends Function {
    Symbol arg1;
    Symbol arg2;
    int numOfArgs = 0;

    TwoArgs(int priority){
        super(priority);
    }
    TwoArgs(Symbol arg1, Symbol arg2,int priority){
        super(priority);
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    void check() throws ONP_Exception {
        if (arg2==null || arg1==null) {
            throw new ONP_ArgumentDoesNotExist();
        }
    }
    String print(String operator){
        if(priority>arg1.priority)
            if(priority>arg2.priority)
                return "(" + arg1.toString() + ") " + operator + " (" + arg2.toString() + ")";
            else
                return "(" + arg1.toString() + ") " + operator + " " + arg2.toString();
        else
        if(priority>arg2.priority)
            return arg1.toString() + " " + operator + " (" + arg2.toString() + ")";
        return arg1.toString() + " " + operator + " " + arg2.toString();
    }
    String write(String operator){
        if(operator!=null && !operator.equals("*")&&!operator.equals("/")) {
            if (arg1.calc() == 0) {
                return ""+arg2;
            } else if (arg2.calc() == 0)
                return ""+arg1;
        }
        else if(arg1.calc()==0 || arg2.calc()==0){
            return "0.0";
        }
        return print(operator);
    }


    @Override
    public int numberOfArgs(){
        return numOfArgs;
    }

    @Override
    public int missingArgs(){
        return 2 - numOfArgs;
    }

    @Override
    public void addArg(Symbol arg){
        if(arg2==null)
            arg2 = arg;
        else if (arg1==null)
            arg1 = arg;
        else
            throw new ONP_TooManyArguments();
    }

    @Override
    public String toString() {
        return write(name);
    }

    // GETTERS

    public Symbol getArg1(){
        return arg1;
    }
    public Symbol getArg2(){
        return arg2;
    }
}
