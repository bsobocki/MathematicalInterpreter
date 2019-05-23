# ONP Interpreter
- ONP (pl. [Odwrotna Notacja Polska](https://pl.wikipedia.org/wiki/Odwrotna_notacja_polska); en. [Reverse Polish Notation](https://en.wikipedia.org/wiki/Reverse_Polish_notation) -> postfix expressions)
- A console program written in Java. 
- Calculator of postfix expressions.
- An interpreter of some commands.

## How it works

If you want to:

 * calculate an postfix expression, write:
    ```
    calc expression
    ```
    For example:
    ```
    calc 3 2 +
    ```
    Return:
    `5.0` 
  
  * add a variable, write:
    ```
    calc value name =
    ```
    For example command:
    ```
    calc 7.5 x =
    ```
    will add to the environment a variable with name `x` and value `7.5`, 
    
    and command:
    ```
    calc 5 a = b = c
    ```
    will add to the environment variables: `a`, `b` and `c` with value `5.0`.
  
  * see all available variables, write:
    ```
    args
    ```
 * clear the environment, write:
    ```
    clear
    ```
 * delete some variables, write:
    ```
    clear vars
    ```
    For example command:
    ```
    clear x y
    ```
    will delete variables `x` and `y` from the environment.
  * exit, write:
    ```
    exit
    ```
    This command ends the program.
