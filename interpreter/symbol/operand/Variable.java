package interpreter.symbol.operand;

import ONP_interpreter.tools.collections.ONP_Set;
import ONP_interpreter.tools.exceptions.ONP_Exception;
import ONP_interpreter.tools.exceptions.ONP_WrongVarableName;
import interpreter.symbol.Symbol;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Variable extends Symbol {
    private String name;
    private static ONP_Set vars = new ONP_Set();

    public Variable(String name){
        super(5);
        Pattern pat = Pattern.compile("\\p{Alpha}\\p{Alnum}*");
        Matcher mat = pat.matcher(name);
        if(mat.matches()) {
            this.name = name;
        }
        else
            throw new ONP_WrongVarableName();
    }
    public String getName() {
        return this.name;
    }

    @Override
    public double calc() throws ONP_Exception {
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String toString2() {
        return name + " = " + calc();
    }
}
