package derivative_interpreter;

import java.util.HashMap;
import java.util.Map;

abstract class Expression{

    protected Expression left;
    protected Expression right;
    public static Map<String,Integer> Hmap = new HashMap<String, Integer>();

    Expression getL() { return left;}
    Expression getR() { return right;}
    public abstract int calc();
    abstract String ToString();
    public abstract String ToString2();
}