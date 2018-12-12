import ONP_interpreter.ONPInterpreter;
import derivative_interpreter.DerivativeInterpreter;
import interpreter.Interpreter;

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
                               case "onp" :
                                   new ONPInterpreter().interpreter();
                                   break;
                               case "derivative":
                                   new DerivativeInterpreter().interpreter();
                                   break;
                               case "commands":
                                   System.out.println(
                                           "onp -> open ONPInterpreter\n" +
                                           "derivative -> open DerivativeInterpreter\n" +
                                           "commands -> show all available commands\n");
                                   break;
                                default:
                                    System.out.println("Wrong command!");
                           }
                   },
                       /*the name of the Interpreter */
                       "Main Interpreter");
       interpreter.interpreter();
   }
}