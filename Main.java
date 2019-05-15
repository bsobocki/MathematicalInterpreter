import ONP_interpreter.ONPInterpreter;
import calculator_interpreter.CalcInterpreter;
import derivative_interpreter.Derivative;
import derivative_interpreter.DerivativeInterpreter;
import function.FunctionTree;
import function.symbol.function.Function;
import interpreter.Interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *Created by Bartosz Sobocki
 */

public class Main {


   public static void main(String[] args ){
       /*
        *create an anonymous class implements Interpreter by lambda abstraction
        *call static function "interpreter" in "interpreter"'s method  body
        *create an anonymous class implements InterpreterBody by lambda abstraction
        *and override "interpreter" method
        *give it as "interpret"'s argument
        */
       Interpreter interpreter = () ->
               Interpreter.interpret(
                       /*the body of the Interpreter */
                       (String command, String arg) -> {
                           switch(command){
                               case "calculator":
                                   new CalcInterpreter().interpreter();
                                   break;
                               case "onp" :
                                   new ONPInterpreter().interpreter();
                                   break;
                               case "derivative":
                                   new DerivativeInterpreter().interpreter();
                                   break;
                               case "commands":
                                   System.out.println(
                                           "calculator -> open CalcInterpreter\n" +
                                           "onp -> open ONPInterpreter\n" +
                                           "derivative -> open DerivativeInterpreter\n" +
                                           "commands -> show all available commands\n" +
                                           "help -> descriptions of available functions\n");
                                   break;
                               case "help":
                                   printHelp();
                                   break;
                                default:
                                    System.out.println("Wrong command!");
                           }
                   },
                       /*the name of the Interpreter */
                       "interpreter");
       interpreter.interpreter();
   }

    public static void printHelp(){
        System.out.println("");
    }
}