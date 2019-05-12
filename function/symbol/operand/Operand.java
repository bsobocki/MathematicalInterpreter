package function.symbol.operand;

import function.symbol.Symbol;

abstract class Operand extends Symbol {
    public Operand(int priority) {
        super(priority);
    }
}