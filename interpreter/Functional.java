package interpreter;

import ONP_interpreter.tools.exceptions.*;
import interpreter.symbol.Symbol;

public interface Functional extends Calculable {
    int numberOfArgs (); // function arity
    int missingArgs ();
    void addArg (Symbol arg) throws ONP_Exception;
}