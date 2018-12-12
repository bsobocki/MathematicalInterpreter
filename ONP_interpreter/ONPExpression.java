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
                        Abs abs = new Abs();
                        abs.addArg(build());
                        return abs;
                    case "atan":
                        Atan at = new Atan();
                        at.addArg(build());
                        return at;
                    case "ceil":
                        Ceil ce = new Ceil();
                        ce.addArg(build());
                        return ce;
                    case "cos":
                        Cos co = new Cos();
                        co.addArg(build());
                        return co;
                    case "exp":
                        Exp exp = new Exp();
                        exp.addArg(build());
                        return exp;
                    case "floor":
                        Floor floor = new Floor();
                        floor.addArg(build());
                        return floor;
                    case "ln":
                        Ln ln = new Ln();
                        ln.addArg(build());
                        return ln;
                    case "sgn":
                        Sgn sgn = new Sgn();
                        sgn.addArg(build());
                        return sgn;
                    case "sin":
                        Sin sin = new Sin();
                        sin.addArg(build());
                        return sin;

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
                        a.addArg1(new Variable(expr.remove()));
                        Symbol c = build();
                        a.addArg(c);
                        set = a.assign(set);
                        return c;

                    /*variable*/
                    default:
                        return new Number(set.get(x));
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
