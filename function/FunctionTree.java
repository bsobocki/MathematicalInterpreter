package function;

import ONP_interpreter.ONPExpression;
import ONP_interpreter.exceptions.ONP_Exception;
import function.symbol.*;
import java.util.ArrayDeque;
import java.util.Stack;

public class FunctionTree {
    private Symbol fun;

    //CONSTRUCTOR
    public FunctionTree(String fun) { this.fun = buildFun(fun); }

    //GETTERS
    public Symbol getFun() { return fun; }

    /**private class Sym using in 'buildFun'*/
    private class Sym{
        String string;
        String symbol;
        int index;

        Sym (String s, int i){
            setString(s);
            setIndex(i);
        }
        void setString(String s) {
            string = s;
        }
        void setSymbol(String s) {
            symbol = s;
        }
        void setIndex(int i){
            index = i;
        }
    }

    /**private class Char using in 'buildFun'*/
    private class FunctionSymbol{
        int priority;// ( ) : 5 | oneArg : 4 | ^ : 3 | * / : 2 | - : 1 | + : 0 |
        char sign; //'t' - two args | 'o' - one arg | 'n' - number
        String symbol;

        FunctionSymbol (String s){
            setSymbol(s);
            setPriority(s);
            setSign(s);
        }

        void setSymbol(String s) { symbol = s; }
        void setSign(char s) { sign = s; }
        void setSign(String s) {
            if(s.length()>0)
                sign =  getSign(s.toCharArray()[0]);
        }
        void setPriority(int p) { priority = p; }
        void setPriority(String symbol){
            switch(symbol){
                case "(":
                case ")":
                    priority = 5;
                    break;
                case "^":
                    priority = 3;
                    break;
                case "*":
                case "/":
                    priority = 2;
                    break;
                case "-":
                    priority = 1;
                    break;
                case "+":
                    priority = 0;
                    break;
                default:
                    priority = 4;
            }
        }
    }

    //METHODS
    Symbol make_ONP(Stack<FunctionSymbol> stack, ArrayDeque<FunctionSymbol> queue){
        StringBuilder str = new StringBuilder();
        String temp;
        if(!queue.isEmpty())
            str.append(queue.pop().symbol);

        while(!queue.isEmpty()){
            str.append(" ").append(queue.pop().symbol);
        }

        while(!stack.isEmpty()){
            str.append(" ").append(stack.pop().symbol);
        }

        if(str.toString().length()>0) {
            ONPExpression onp = new ONPExpression(str.toString());
            return onp.getTreeExpression();
        }else
            throw new RuntimeException("Wrong Expression! Can't build function!");
    }
    private boolean isNotWhiteLine(String s){
        boolean b = true;
        for(char x : s.toCharArray()){
            b = b && !Character.isWhitespace(x);
        }
        return b;
    }
    /**build function from String*/
    private Symbol buildFun(String fun){
        Sym sym = new Sym(fun,0);

        Stack<FunctionSymbol> stack = new Stack<>();
        ArrayDeque<FunctionSymbol> queue = new ArrayDeque<>();

        while(sym.index < fun.length()) {
            /* update sym.symbol and sym.priority */
            getSymbol(sym);
            if (!sym.symbol.equals("") && sym.symbol != null && isNotWhiteLine(sym.symbol)) {
                /* create symbol with its priority and sigh */
                FunctionSymbol c = new FunctionSymbol(sym.symbol);
                /* if symbol is an operator */
                if (c.sign == 'o' || c.sign == 't') {
                    if (!stack.isEmpty() && stack.peek().priority > c.priority) {
                        while (stack.peek().priority > c.priority)
                            queue.addLast(stack.pop());
                    }
                    stack.push(c);
                } else
                    queue.addLast(c);
            }
        }
        return make_ONP(stack, queue);
    }
    /**check a sign of the Symbol getting by getSymbol*/
    char getSign(char a){
        if(a>='0' && a<='9')
            return 'n';
        else if (Character.isWhitespace(a))
            return 'e';
        else if(a>='a' && a<='z' || a>='A' && a<='Z')
            return 't';
        else if(a=='(' || a==')')
            return 'b';
        /* operator */
        return 'o';
    }
    /**return a next symbol from string*/
    private Sym getSymbol(Sym str){
        StringBuilder toReturn = new StringBuilder();

        int i = str.index;
        char type = 'e'; // 'n' : number | 'x' : text | 'o' : operator | 'e' : empty | 'b' : brackets
        char [] arr = str.string.toCharArray();

        while(i<str.string.length() && Character.isWhitespace(arr[i]))
            i++;

        if(i<str.string.length())
            type = getSign(arr[i]);

        while(i<str.string.length() && getSign(arr[i])==type) {
            if(!Character.isWhitespace(arr[i]))
                toReturn.append(arr[i]);
            i++;
        }

        str.setIndex(i);
        str.setSymbol(toReturn.toString());

        return str;
    }
    /**calculate function*/
    public double calc() throws ONP_Exception { return fun.calc(); }
    /**represent function as String*/
    @Override public String toString() {
        return fun.toString();
    }
    /**represent function as String with value*/
    public String toString2() {
        return fun.toString2();
    }
}
