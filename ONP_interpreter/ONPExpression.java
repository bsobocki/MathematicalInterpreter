package ONP_interpreter;

import ONP_interpreter.tools.collections.*;
import ONP_interpreter.tools.exceptions.*;
import interpreter.symbol.Symbol;
import interpreter.symbol.function.twoArgs.*;
import interpreter.symbol.function.oneArg.*;
import interpreter.symbol.function.constant.*;
import interpreter.symbol.operand.*;
import interpreter.symbol.operand.Number;

/**a class that storages an expression*/
public class ONPExpression {
    /**collections necessary to calculate*/
    private ONP_Set set;
    private ONP_List expr;
    private Symbol treeExpression;

    /**constructors*/
    public ONPExpression() throws ONP_Exception{
        set = new ONP_Set();
        expr = new ONP_List();
    }
    public ONPExpression(String onp) throws ONP_Exception{
        set = new ONP_Set();
        expr = new ONP_List();
        setExpression(onp);
    }
    public void setExpression(String onp) throws ONP_Exception {
        expr = onp_symbols_prefix(onp);
        treeExpression = build();
    }

    /**method creates ONP_List which storages an prefix expressioin*/
    public static ONP_List onp_symbols_prefix(String str){
        /*to build an single symbol*/
        String temp = "";
        /*to build an postfix expression and reverse it*/
        ONP_List arrayList = new ONP_List();
        /*string to char array*/
        char[] charArray = str.toCharArray();

        /*add symbols to arrayList*/
        for(char x: charArray){
            if(x != ' ' && x != '\n'){
                temp+=x;
            }
            else{
                arrayList.add(temp);
                temp = "";
            }
        }
        /*add last symbol*/
        if(charArray.length!=0)
            if(charArray[str.length()-1]!=' ')
                arrayList.add(temp);

        arrayList.reverse();

        return arrayList;
    }

    /**build a tree-expression from prefix*/
    private Symbol build() throws ONP_Exception{
        if(!expr.isEmpty()) {
            String x = expr.remove();
            /*number*/
            if (x.toCharArray()[0] >= '0' && x.toCharArray()[0] <= '9')
                return new Number(Double.parseDouble(x));
            else
                switch (x){
                    /*constant*/
                    case "e":
                        return new E();
                    case "pi":
                        return new Pi();
                    case "phi":
                        return new Phi();

                    /*function 1-arg*/
                    case "abs":
                        return new Abs(build());
                    case "atan":
                        return new Atan(build());
                    case "ceil":
                        return new Ceil(build());
                    case "cos":
                        return new Cos(build());
                    case "exp":
                        return new Exp(build());
                    case "floor":
                        return new Floor(build());
                    case "ln":
                        return new Ln(build());
                    case "sgn":
                        return new Sgn(build());
                    case "sin":
                        return new Sin(build());

                    /*function 2-args*/
                    case "+":
                        Plus pl = new Plus();
                        pl.addArg(build());
                        pl.addArg(build());
                        return pl;
                    case "-":
                        Minus minus = new Minus();
                        minus.addArg(build());
                        minus.addArg(build());
                        return minus;
                    case "/":
                        Divide div = new Divide();
                        div.addArg(build());
                        div.addArg(build());
                        return div;
                    case "*":
                        Multiply mlt = new Multiply();
                        mlt.addArg(build());
                        mlt.addArg(build());
                        return mlt;
                    case "log":
                        Log log = new Log();
                        log.addArg(build());
                        log.addArg(build());
                        return log;
                    case "max":
                        Max max = new Max();
                        max.addArg(build());
                        max.addArg(build());
                        return max;
                    case "min":
                        Min min = new Min();
                        min.addArg(build());
                        min.addArg(build());
                        return min;
                    case "pow":
                        Pow pow = new Pow();
                        pow.addArg(build());
                        pow.addArg(build());
                        return pow;
                    /*assign*/
                    case "=":
                        Assign a = new Assign();
                        a.addArg1(new Variable(expr.remove(),0));
                        Symbol c = build();
                        a.addArg(c);
                        set = a.assign(set);
                        return c;

                    /*variable*/
                    default:
                        if(set.get(x)!=null)
                            return new Variable(x,set.get(x));
                        else
                            throw new ONP_UnknownSymbol();
                }
        }
        else
        /*normal tree ends on leaves (constant or numbers)*/
            throw new ONP_WrongExpression();
    }

    /**calculate expression*/
    public double calculate(){
        return treeExpression.calc();
    }

    /**getter*/
    public ONP_Set getSet() {
        return set;
    }
    public Symbol getTreeExpression() {
        return treeExpression;
    }
}
