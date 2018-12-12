package interpreter.symbol.function.constant;

import interpreter.symbol.Symbol;

public abstract class Constant extends Symbol{
    public Constant() {
        super(5);
    }

    @Override
    public String toString(){
        return "" + calc();
    }

    @Override
    public String toString2(){
        return "" + calc();
    }
}
