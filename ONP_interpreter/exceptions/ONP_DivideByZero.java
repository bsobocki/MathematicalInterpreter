package ONP_interpreter.exceptions;

public class ONP_DivideByZero extends ONP_Exception {

    public ONP_DivideByZero() {
        super("Attempt to divide by zero!");
    }
}