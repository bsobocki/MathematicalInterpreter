package function;

import ONP_interpreter.tools.exceptions.ONP_Exception;
import interpreter.symbol.Symbol;

public class FunctionTree {
    private Symbol fun;

    //CONSTRUCTOR
    public FunctionTree(String fun) {
        this.fun = buildFun(fun);
    }

    //GETTERS
    public Symbol getFun() { return fun; }

    //METHODS
    /**build function from String*/
    private Symbol buildFun(String fun){
        String str = getSymbol(fun);
        return null;
    }
    /**check if the symbol is an operator*/
    private boolean isOperator(String str){
        return str.equals("+");
    }
    /**return a next symbol from string*/
    private String getSymbol(String str){
        return null;
    }
    /**calculate function*/
    public double calc() throws ONP_Exception {
        return fun.calc();
    }
    /**represent function as String*/
    @Override public String toString() {
        return fun.toString();
    }
    /**represent function as String with value*/
    public String toString2() {
        return fun.toString2();
    }
}
