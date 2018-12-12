package ONP_interpreter.tools.exceptions;

public class ONP_WrongVarableName extends ONP_Exception {
    public ONP_WrongVarableName() {
        super("Name of the variable is not matching to pattern \"\\\\p { Alpha }\\\\p { Alnum }*\"");
    }
}
