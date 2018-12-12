package derivative_interpreter;

import interpreter.symbol.Symbol;
import interpreter.symbol.function.constant.*;
import interpreter.symbol.function.oneArg.*;
import interpreter.symbol.function.twoArgs.*;
import interpreter.symbol.operand.*;

class Derivative {
    /**function representation*/
    private double value;
    private String representation;

    Derivative(Symbol function) {
        value = calc(function);
        representation = ToString(function);
    }
    public String getRepresentation() {
        return representation;
    }
    public double getValue() {
        return value;
    }

    /**derivative reprezentation of the function as value*/
    public double calc(Symbol function) {

        /**check what is function (its type)*/
        if (function==null) {
            return 0;
        }
        else if (function.getClass().isAssignableFrom(Constant.class)) { //if Constant
            return 0;
        }
        else if (function.getClass().isAssignableFrom(Variable.class)){ //if Variable
            return 1;
        }
        else if (function.getClass().isAssignableFrom(Pow.class)) {

        }
        else if (function.getClass().isAssignableFrom(Plus.class)) {

        }
        else if (function.getClass().isAssignableFrom(Minus.class)) {

        }
        else if (function.getClass().isAssignableFrom(Multiply.class)) {

        }
        else if (function.getClass().isAssignableFrom(Divide.class)) {

        }
        return 0;
    }

    /**derivative representation of the funkction as string*/
    public String ToString(Symbol function) {
        if (function==null) {
            return "";
        }
        else if (function.getClass().isAssignableFrom(Constant.class)) { //if Constant
            return "0";
        }
        else if (function.getClass().isAssignableFrom(Variable.class)){ //if Variable
            return "1";
        }
        else if (function.getClass().isAssignableFrom(Pow.class)) { //if Power

        }
        else if (function.getClass().isAssignableFrom(Plus.class)) { //if Plus

        }
        else if (function.getClass().isAssignableFrom(Minus.class)) { //if Minus

        }
        else if (function.getClass().isAssignableFrom(Multiply.class)) { //if Multiply

        }
        else if (function.getClass().isAssignableFrom(Divide.class)) { //if Divide

        }
        return "Incorrect type";
    }
}

