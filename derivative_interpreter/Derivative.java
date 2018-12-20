package derivative_interpreter;

import function.FunctionTree;
import interpreter.symbol.Symbol;
import interpreter.symbol.function.constant.*;
import interpreter.symbol.function.oneArg.*;
import interpreter.symbol.function.twoArgs.*;
import interpreter.symbol.operand.*;
import interpreter.symbol.operand.Number;

class Derivative {
    /**function representation*/
    private double value;
    private String representation;
    private Symbol function;
    private Symbol derivative;

    //CONSTRUCTOR
    Derivative(String f) throws Exception {
        function = new FunctionTree(f).getFun();
        derivative = buildDer(function);
        value = derivative.calc();
        representation = function.toString();
    }
    //GETTERS
    public double getValue() { return value; }
    public Symbol getDerivative() { return derivative; }
    public Symbol getFunction() { return function; }
    //BUILDERS
    /**derivative reprezentation of the function as value*/
    private Symbol buildDer(Symbol function) throws Exception {
        //Null
        if (function==null)
            return new Number(0);
        //Constant
        else if (function.getClass().isAssignableFrom(Constant.class))
            return new Number(0);
        //Variable
        else if (function.getClass().isAssignableFrom(Variable.class))
            return new Number(1);
        //oneArg
        else if (function.getClass().isAssignableFrom(OneArg.class))
            return build1ArgDer((OneArg)function);
        //twoArgs
        else
            return build2ArgDer((TwoArgs)function);

    }
    private Symbol build2ArgDer(TwoArgs function) throws Exception{
        TwoArgs f = (TwoArgs) function.getArg1();
        TwoArgs g = (TwoArgs) function.getArg2();
        //Plus
        if(function.getClass().isAssignableFrom(Plus.class))
            return new Plus(
                    buildDer(f) ,
                    buildDer(g) );
        //Minus
        else if (function.getClass().isAssignableFrom(Minus.class))
            return new Minus (
                    buildDer(f) ,
                    buildDer(g) );
        //Multiply
        else if (function.getClass().isAssignableFrom(Multiply.class))
            return new Plus (
                    new Multiply(buildDer(f) , g) ,
                    new Multiply(buildDer(g) , f) );
        //Divide
        else if(function.getClass().isAssignableFrom(Divide.class))
            return new Divide(
                    new Minus(
                            new Multiply(
                                    buildDer(f) ,
                                    g) ,
                            new Multiply(
                                    buildDer(g) ,
                                    f)) ,
                    new Pow(
                            g,
                            new Number(2))  );
        //Logarithm f g
        else if(function.getClass().isAssignableFrom(Log.class))
            return new Divide(
                    new Number(1) ,
                    new Multiply(
                            g ,
                            new Log(
                                    new E(),
                                    f)));
        //Power
        else if(function.getClass().isAssignableFrom(Pow.class)){
            //( x^g )' = x^(g-1)(x*log(x)*g' + g)
            if(f.getClass().isAssignableFrom(Variable.class))
                return new Multiply(
                        new Plus(
                                g,
                                new Multiply(
                                        f,
                                        new Multiply(
                                                new Log(
                                                        new E(),
                                                        f),
                                                buildDer(g)))),
                        new Pow(
                                f,
                                new Minus(
                                        g,
                                        new Number(1))));
            //( e^f )' = e^g * g'
            else if (f.getClass().isAssignableFrom(E.class))
                return new Multiply(
                        new Pow(f,g) ,
                        buildDer(g));
            //( a^g )' = log(a) * a^g * g'
            else if(f.getClass().isAssignableFrom(Constant.class))
                return new Multiply(
                        new Log(
                                new E(),
                                f) ,
                        new Multiply(
                                new Pow(
                                        f,
                                        g) ,
                                buildDer(g)));
            //( f^g )' = f^(g - 1) *  (f * g' * log(f) + g * f')
            else
                return new Multiply(
                        new Pow(
                                f,
                                new Minus(
                                        g,
                                        new Number(1))) ,
                        new Plus(
                                new Multiply(
                                        f,
                                        new Multiply(
                                                buildDer(g) ,
                                                new Log(new E(), f))) ,
                                new Multiply(
                                        g,
                                        buildDer(f))));
        }
        //Minimum
        else if(function.getClass().isAssignableFrom(Min.class))
            //                 | f'  f <= g
            //(min( f, g ))' = {
            //                 | g'  f > g
            return f.calc() <= g.calc() ? buildDer(f) : buildDer(g);
        //Maximum
        else
            //                 | f'  f >= g
            //(max( f, g ))' = {
            //                 | g'  f < g
            return f.calc() >= g.calc() ? buildDer(f) : buildDer(g);
    }
    private Symbol build1ArgDer(OneArg function) throws Exception {
        Symbol f = function.getArg();
        //( sin f )' = cos(f) * f'
        if(function.getClass().isAssignableFrom(Sin.class))
            return new Multiply(
                    new Cos(f),
                    buildDer(f));
        //( cos f )' = - sin(f) * f'
        else if (function.getClass().isAssignableFrom(Cos.class))
            return new Multiply(
                    new Minus(
                            new Number(0),
                            new Sin(f)),
                    buildDer(f));
        //( |f| )' = f * f' / |f| = sgn(f) * f'
        else if (function.getClass().isAssignableFrom(Abs.class))
            return new Multiply(
                    new Sgn(f),
                    buildDer(f));
        //( atan f )' = f'/(f'+1)
        else if (function.getClass().isAssignableFrom(Atan.class))
            return new Divide(
                    buildDer(f),
                    new Plus(
                            new Pow(
                                    f,
                                    new Number(2)),
                            new Number(1)));
        //( e^f )' = e^f * f'
        else if (function.getClass().isAssignableFrom(Exp.class))
            return new Multiply(
                    new Exp(f),
                    buildDer(f));
        //( ln(f) )' = f'/f
        else if (function.getClass().isAssignableFrom(Ln.class))
            return new Multiply(
                    buildDer(f),
                    f);
        else
            throw new Exception("Incorrect function to count derivative");
    }
    //REPRESENTATION AS STRING
    /**derivative representation of the function as string*/
    @Override public String toString() {
        return representation;
    }
    public String toString2(){
        return representation + " = " + value;
    }
}

