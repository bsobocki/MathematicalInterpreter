package derivative_interpreter;

import function.FunctionTree;
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
                    Derivative der = new Derivative();
                    /*commands interpretation */
                    switch (command) {
                        case "calc":
                            //try {
                                der.setFunction(arg);
                                System.out.println(der.getDerivative().toString());
                            //} catch (Exception e) {
                                //System.out.println("Message : " + e.getMessage());
                            //}
                            break;
                        case "last-der":
                            if(der.getDerivative()!=null)
                                System.out.println(der.getDerivative().toString());
                            else
                                System.out.println("Nothing to print!");
                            break;
                        case "last-fun":
                            if(der.getFunction()!=null)
                                System.out.println(der.getFunction().toString());
                            else
                                System.out.println("Nothing to print!");
                            break;
                        case "args":

                            break;
                        default:
                            System.out.println("Wrong command!");
                    }
                },
                /*the name of the DerivativeInterpreter*/
                "derivative-calculator");
    }
}