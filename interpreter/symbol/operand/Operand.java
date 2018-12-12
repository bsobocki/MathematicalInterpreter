package interpreter.symbol.operand;

import interpreter.symbol.Symbol;

abstract class Operand extends Symbol {
    public Operand(int priority) {
        super(priority);
    }
}