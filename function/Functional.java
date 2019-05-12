package function;

import function.Calculable;
import function.symbol.*;
import ONP_interpreter.exceptions.*;

public interface Functional extends Calculable {
    int numberOfArgs (); // function arity
    int missingArgs ();
    void addArg (Symbol arg) throws ONP_Exception;
}