package ONP_interpreter.exceptions;

public class ONP_UnknownSymbol extends ONP_Exception {

    public ONP_UnknownSymbol(String sym) {
        super("A unknown symbol \"" +sym+ "\" has been entered!");
    }
}
