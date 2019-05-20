package function;

import ONP_interpreter.ONPExpression;
import ONP_interpreter.exceptions.ONP_Exception;
import function.symbol.*;
import interpreter.collections.Set;

import java.util.ArrayDeque;
import java.util.Stack;

public class FunctionTree {
    private Symbol fun;
    private Set vars;
    private Set unknownValues;

    //CONSTRUCTOR
    public FunctionTree(String fun) {
        vars = new Set();
        unknownValues = new Set();
        this.fun = buildFun(fun);
    }
    public FunctionTree(String fun, Set vars, Set unknownVals){
        this.vars = vars;
        this.unknownValues = unknownVals;
        this.fun = buildFun(fun);
    }

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
    /**build function from String*/
    private Symbol buildFun(String fun){
        Sym sym = new Sym(fun,0);

        Stack<FunctionSymbol> stack = new Stack<>();
        ArrayDeque<FunctionSymbol> queue = new ArrayDeque<>();

        sym.setIndex(addExpression(fun, sym.index, queue));

        return createFunctionTree(stack, queue);
    }
    /**add a function from brackets to queue*/
    private int addExpression(String fun,int index, ArrayDeque<FunctionSymbol> q){
        Sym sym = new Sym(fun,index);
        Stack<FunctionSymbol> stack = new Stack<>();
        ArrayDeque<FunctionSymbol> queue = new ArrayDeque<>();

        while(sym.index < fun.length()) {
            /* update sym.symbol and sym.priority */
            getSymbol(sym);
            if (!sym.symbol.equals("") && sym.symbol != null && isNotWhiteLine(sym.symbol)) {
                /* create symbol with its priority and sigh */
                FunctionSymbol c = new FunctionSymbol(sym.symbol);
                /* if symbol is an operator */
                String s = symbolFromText(sym.symbol);
                if (s.equals("1arg") || s.equals("2arg")){
                    if (!stack.isEmpty() && stack.peek().priority > c.priority) {
                        while (!stack.isEmpty() && stack.peek().priority > c.priority)
                            queue.addLast(stack.pop());
                    }
                    stack.push(c);
                } else if (c.sign == '='){
                    stack.push(c);
                } else if (c.sign == '('){
                    sym.setIndex(addExpression(fun, sym.index, queue));
                } else if (c.sign == ')')
                    break;
                else {
                    queue.addLast(c);
                }
            }
        }

        while (!queue.isEmpty()){
            q.addLast(queue.pop());
        }
        while (!stack.isEmpty()){
            q.addLast(stack.pop());
        }

        return sym.index;
    }
    /**build a string with ONPexpression from stack and queue*/
    private String make_ONP(Stack<FunctionSymbol> stack, ArrayDeque<FunctionSymbol> queue ){
        StringBuilder str = new StringBuilder();

        if(!queue.isEmpty())
            str.append(queue.pop().symbol);

        while(!queue.isEmpty()){
            str.append(" ").append(queue.pop().symbol);
        }

        while(!stack.isEmpty()){
            str.append(" ").append(stack.pop().symbol);
        }

        return str.toString();
    }
    /**create function as Symbol from String from make_ONP*/
    private Symbol createFunctionTree(Stack<FunctionSymbol> stack, ArrayDeque<FunctionSymbol> queue){
        String str = make_ONP(stack,queue);

        System.out.println(str);

        if(str.length()>0) {
            ONPExpression onp = new ONPExpression(vars,str);
            vars = onp.getSet();
            return onp.getTreeExpression();
        }else
            throw new RuntimeException("Wrong Expression! Can't build function!");
    }
    /**check if 's' is a line with only white characters*/
    private boolean isNotWhiteLine(String s){
        boolean b = true;
        for(char x : s.toCharArray()){
            b = b && !Character.isWhitespace(x);
        }
        return b;
    }
    /**check a sign of the Symbol getting by getSymbol*/
    private char getSign(char a){
        if(a>='0' && a<='9')
            return 'n';
        else if (Character.isWhitespace(a))
            return 'e';
        else if(a>='a' && a<='z' || a>='A' && a<='Z')
            return 't';
        else if(a=='(' || a==')' || a=='=')
            return a;
        /* operator */
        return 'o';
    }
    /**return a next symbol from string*/
    private void getSymbol(Sym str){
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
    }
    /**check what text is*/
    private String symbolFromText(String text){
        switch (text) {
            /*constatent*/
            case "e":
            case "pi":
            case "phi":
                return "const";

            /*function 1-arg*/
            case "abs":
            case "atan":
            case "ceil":
            case "cos":
            case "exp":
            case "floor":
            case "ln":
            case "sgn":
            case "sin":
                return "1arg";

            /*function 2-args*/
            case "+":
            case "-":
            case "/":
            case "*":
            case "^":
            case "log":
            case "max":
            case "min":
            case "pow":
                return "2arg";

            /*assign*/
            case "=":
                return "assign";

            /*variable*/
            default:
                return "var";
        }

    }
    /**calculate function*/
    public double calc() throws ONP_Exception { return fun.calc(); }

    //SETTERS
    public void setVars(Set v) { vars = v; }

    //GETTERS
    public Set getUnknownValues() { return unknownValues; }
    public Set getVars() { return vars; }
    /**represent function as String*/
    @Override public String toString() { return fun.toString(); }
    /**represent function as String with value*/
    public String toString2() { return fun.toString2(); }
}
