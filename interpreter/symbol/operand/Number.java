package interpreter.symbol.operand;

import ONP_interpreter.tools.exceptions.ONP_Exception;

public class Number extends Operand {
    private double val;

    public Number(double val){
        super(5);
        this.val = val;
    }

    public double getVal() {
        return val;
    }

    @Override
    public double calc() throws ONP_Exception {
        return val;
    }

    @Override
    public String toString() {
        return "" + val;
    }

    @Override
    public String toString2() {
        return toString();
    }
}
