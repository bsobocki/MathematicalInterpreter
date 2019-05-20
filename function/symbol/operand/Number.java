package function.symbol.operand;

import ONP_interpreter.exceptions.ONP_Exception;

public class Number extends Operand {
    private double val;

    public Number(double val){
        this.val = val;
        _class = 'n';
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
