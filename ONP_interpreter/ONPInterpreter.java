package ONP_interpreter;

import interpreter.Interpreter;

public class ONPInterpreter implements Interpreter {
    @Override
    public void interpreter() {
        /*create new ONPExpression object to storage an ONP expression*/
        ONPExpression expr = new ONPExpression();
        /* body of the ONPInterpreter (lambda abstraction) */
        Interpreter.interpret(
                /*the body of the ONPInterpreter */
                (String command, String arg) -> {
                    /*commands interpretation*/
                    switch (command) {
                        case "calc":
                            expr.setExpression(arg);
                            System.out.println(expr.calculate());
                            break;
                        case "clear":
                            expr.getSet().clear(arg);
                            break;
                        case "args":
                            expr.getSet().write();
                            break;
                        case "infix":
                            expr.setExpression(arg);
                            System.out.println(expr.getTreeExpression().toString());
                            break;
                        default:
                            System.out.println("Wrong command!");
                    }
                },
                /* the name of the ONPInterpreter */
                "onp-calculator");
    }
}
