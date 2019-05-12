package interpreter;

import java.util.Scanner;

public interface Interpreter {

    /**read and interpret commands and its argument*/
    void interpreter ();

    /**read and interpret commands and its argument*/
    static void interpret(InterpreterBody body, String interpreterName) {
        System.out.println("The " + interpreterName + " has been opened.");
        /*create scanner necessary to enter commands by user*/
        Scanner scan = new Scanner(System.in);
        System.out.print("["+interpreterName+"]: ");
        /*variables to storage the lines with commands entered by user*/
        String line = scan.nextLine();
        String command = "";
        String arg;
        try {
            /* make command only if line have some non-white characters */
            if(!Interpreter.isWhiteLine(line)){
                command = Interpreter.read(line)[0];
                arg = Interpreter.read(line)[1];
                /* interpreting a command */
                while (!command.equals("exit")) {
                    /* in loop we can't go to the switch again after while line
                     * because the command and the arg will not change */
                    if(!Interpreter.isWhiteLine(line)) {
                        body.body(command, arg);
                    }

                    /* getting a new line */
                    System.out.print("["+interpreterName+"]: ");
                    line = scan.nextLine();
                    if(!Interpreter.isWhiteLine(line)) {
                        command = Interpreter.read(line)[0];
                        arg = Interpreter.read(line)[1];
                    }
                }
            }
        } catch (Exception exc) {
            System.out.println("Error: " + exc.getClass() + "   message: " + exc.getMessage());
            interpret(body,interpreterName);
        }
        /*if user want to exit from the interpreter*/
        if(command.equals("exit"))
            System.out.println("The " + interpreterName + " has been closed!");
        else
            interpret(body,interpreterName);
    }

    /**read line and separate command and its argument*/
    static String[] read(String str){
        /* when user enters command without space, method may have a problem */
        /* for example "clear" */
        char[] tab = (str+' ').toCharArray();
        /* create 2 empty strings */
        String[] strings = {"",""};
        int i = 0;
        /* skip spaces at the beginning */
        while (tab[i]==' '){
            i++;
        }
        /* get command */
        while(tab[i]!=' '){
            strings[0] += tab[i];
            i++;
        }
        i++;
        /* get argument*/
        for(; i<tab.length; i++){
            strings[1]+=tab[i];
        }
        /* return command and argument */
        return strings;
    }

    /**check if line has only white characters */
    static boolean isWhiteLine(String line){
        for(Character x:line.toCharArray()){
            if(!Character.isWhitespace(x))
                return false;
        }
        return true;
    }

    /* INTERFACE */
    //to create the interpreter body
    interface InterpreterBody{
        void body(String command, String arg) throws Exception;
    }
}
