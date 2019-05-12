package function.symbol;

import function.Calculable;

public abstract class Symbol implements Calculable {
    public int priority;

    public Symbol(int priority){ this.priority = priority; }
    public abstract String toString();
    public abstract String toString2();
}