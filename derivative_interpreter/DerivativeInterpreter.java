package derivative_interpreter;

import function.FunctionTree;
import interpreter.Interpreter;

import java.util.Scanner;

/**
 * Created by Bartosz Sobocki on 2018-03-29.
 */

public class DerivativeInterpreter implements Interpreter {
        private Derivative der;

    @Override
    public void interpreter() {
        try {
            der = new Derivative();
        } catch (Exception e){
            e.printStackTrace(); System.out.println("message: "+e.getMessage());
        }
        Interpreter.interpret(
                /*the DerivativeInterpreter's body */
                (String command, String arg) -> {
                    /*commands interpretation */
                    switch (command) {
                        case "set-variable":
                            der.setVar(arg);
                            break;
                        case "add-variable":
                            der.getFunctionTree().getVars().add(arg,0.0);
                            break;
                        case "update-variable":
                            System.out.println("New value: ");
                            Scanner s = new Scanner(System.in);
                            Double val = Double.parseDouble(s.next());
                            der.getFunctionTree().getVars().add(arg,val);
                            break;
                        case "set-unknown-value":
                            der.getFunctionTree().getUnknownValues().add(arg,0.0);
                            break;
                        case "vars":
                            der.getFunctionTree().getVars().write();
                            break;
                        case "calc":
                                der.setFunction(arg);
                                System.out.println(der.getDerivative());
                            break;
                        case "last-der":
                            if(der.getDerivative()!=null)
                                System.out.println(der.getDerivative().toString());
                            else
                                System.out.println("Nothing to print!");
                            break;
                        case "last-fun":
                            if(der.getFunction()!=null)
                                System.out.println(der.getFunction());
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