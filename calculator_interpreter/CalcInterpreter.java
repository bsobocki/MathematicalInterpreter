package calculator_interpreter;

import interpreter.Interpreter;
import interpreter.collections.Set;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcInterpreter implements Interpreter {
    @Override
    public void interpreter() {

        Set vars = new Set();

        Interpreter.interpret(
                /*the body of the CalcInterpreter */
                (String command, String arg) -> {
                    String str = command + arg;
                },"calculator");
    }
}
