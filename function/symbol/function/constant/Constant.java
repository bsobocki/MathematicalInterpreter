package function.symbol.function.constant;

import function.symbol.Symbol;

public abstract class Constant extends Symbol{
    public Constant() {
        super(6);
        _class = 'c';
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
