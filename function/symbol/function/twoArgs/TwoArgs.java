package function.symbol.function.twoArgs;

import function.symbol.*;
import function.symbol.function.Function;
import ONP_interpreter.exceptions.*;
import function.symbol.function.oneArg.OneArg;
import function.symbol.operand.*;

public abstract class TwoArgs extends Function {
    Symbol arg1;
    Symbol arg2;
    private int numOfArgs = 0;

    TwoArgs(int priority){
        super(priority);
        _class = 't';
    }
    TwoArgs(Symbol arg1, Symbol arg2, int priority){
        super(priority);
        this.arg1 = arg1;
        this.arg2 = arg2;
        _class = 't'; //two args
    }

    void check() throws ONP_Exception {
        if (arg2==null || arg1==null) {
            throw new ONP_ArgumentDoesNotExist();
        }
    }
    private boolean isVarOrUnknown(){
        if(arg1._class == 't'){
            TwoArgs ta = (TwoArgs) arg1;
            if (ta.arg2._class == 'v' || ta.arg2._class == 'u')
                return true;
        }
        if(arg2._class == 't'){
            TwoArgs ta = (TwoArgs) arg2;
            return ta.arg1._class == 'v' || ta.arg1._class == 'u';
        }
        if (arg2._class == 'o'){
            return true;
        }
        return arg1._class=='v' || arg1._class == 'u'  ||
                arg2._class == 'v' || arg2._class == 'u';
    }
    String print(String operator){
        String oper = operator;
        oper = " "+oper+" ";

        if((operator.equals("*") || operator.equals("/")) && isVarOrUnknown()) {
            oper = "";
        }

        if(priority>arg1.priority) {
            if (priority > arg2.priority)
                return "(" + arg1.toString() + ")" + oper + "(" + arg2.toString() + ")";
            else
                return "(" + arg1.toString() + ")" + oper + "" + arg2.toString();
        }else if(priority>arg2.priority)
            return arg1.toString() + "" + oper + "(" + arg2.toString() + ")";
        return arg1.toString() + "" + oper + "" + arg2.toString();
    }
    String write(String operator){
        if(operator!=null && !operator.equals("*")&&!operator.equals("/")) {
            if (arg1.calc() == 0) {
                this.priority = arg2.priority;
                this._class = arg2._class;
                return ""+arg2;
            } else if (arg2.calc() == 0) {
                this.priority = arg1.priority;
                this._class = arg1._class;
                return "" + arg1;
            }
        }
        else if(arg1.calc()==0 || arg2.calc()==0){
            priority = 6;
            return "0.0";
        }
        else if(arg1.calc()==1) {
            this.priority = arg2.priority;
            return "" + arg2;
        }
        else if(arg2.calc()==1) {
            this.priority = arg1.priority;
            return "" + arg1;
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
