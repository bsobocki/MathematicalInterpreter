package derivative_interpreter;

import interpreter.Interpreter;

/**
 * Created by Bartosz Sobocki on 2018-03-29.
 */

public class DerivativeInterpreter implements Interpreter {
    @Override
    public void interpreter() {
        Interpreter.interpret(
                /*the DerivativeInterpreter's body */
                (String command, String arg) -> {
                    /*commands interpretation */
                    switch (command) {
                        case "calc":

                            break;
                        case "clear":

                            break;
                        case "args":

                            break;
                        case "infix":

                            break;
                        default:
                            System.out.println("Wrong command!");
                    }
                },
                /*the name of the DerivativeInterpreter*/
                "DerivativeInterpreter");
    }
}