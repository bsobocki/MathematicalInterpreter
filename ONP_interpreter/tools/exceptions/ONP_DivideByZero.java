package ONP_interpreter.tools.exceptions;

public class ONP_DivideByZero extends ONP_Exception {

    public ONP_DivideByZero() {
        super("Attempt to divide by zero!");
    }
}