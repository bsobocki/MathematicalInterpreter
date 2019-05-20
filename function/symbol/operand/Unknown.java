package function.symbol.operand;

import ONP_interpreter.exceptions.ONP_Exception;

public class Unknown extends Operand{
    private String name;

    public Unknown(String name) {
        this.name = name;
        _class = 'u';
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "" + name;
    }

    @Override
    public String toString2() {
        return toString();
    }

    @Override
    public double calc() throws ONP_Exception {
        return 0;
    }
}
