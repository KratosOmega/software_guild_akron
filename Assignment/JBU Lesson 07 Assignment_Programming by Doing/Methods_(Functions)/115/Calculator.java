
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // Change double to String for a is the key to recognize the first input
        // as operands or operation (for sin cos tan)
        // => Variable Setup
        String op = "";
        String a = "";
        String b = "";
        double c = 0;
        double num1 = 0;
        double num2 = 0;

        //        myString.split("\\s+");
        // => 3 kinds of input combos
        do {
            menu();
            
            System.out.print("> ");
            a = keyboard.next();

            // => num + op && num + op + num
            if (isDouble(a) || isInteger(a)){
                // => num + op

                // => Convert operands from String to Double
                num1 = toDouble(a);
                op = keyboard.next();

                // => num + op + num
                // When this is not a factorials operation
                // Take the 2nd operand if this is not a factorials calculation
                if (!op.equals("!")) {
                    b = keyboard.next();
                    num2 = toDouble(b);
                }
            } else {
                op = a;
                a = keyboard.next();
                num1 = toDouble(a);
            }

            // All operands should all be double type for calculation
            // The final result will be convert to integer depend on their decimal
            // => Quit the program (by break the while loop)
            if (num1 == 0.0) {
                System.out.println("Bye, now.");
                break;
            }

            // => switch, to recognize the operations & call the proper methods for calculation
            switch (op) {
                case "+":
                    c = add(num1, num2);
                    break;
                case "-":
                    c = subtract(num1, num2);
                    break;
                case "*":
                    c = multiply(num1, num2);
                    break;
                case "/":
                    c = divide(num1, num2);
                    break;
                case "^":
                    c = exponents(num1, num2);
                    break;
                case "%":
                    c = modulus(num1, num2);
                    break;
                case "!":
                    c = factorials(num1);
                    break;
                case "sin":
                    c = sin(num1);
                    break;
                case "cos":
                    c = cos(num1);
                    break;
                case "tan":
                    c = tan(num1);
                    break;
                case "sqrt":
                    c = sqrt(num1);
                    break;
                case "nroot":
                    c = root(num1, num2);
                    break;
                default:
                    System.out.println("Undefined operator: '" + op + "'! Please Enter again...");
            }

            // Display result
            if (c % 1 == 0) {
                System.out.println("= " + (int) c);
            } else {
                System.out.print("= ");
                System.out.printf("%.4f", c);
                System.out.println("");
            }
        } while (true);
    }

    // Use to conver operand input from String to either int or doublle
    public static double toDouble(String num) {
        return Double.valueOf(num);
    }

    // used for c, convert result to intger or remain double
    // If result is integer, remove decimal
    // If result is float number, keep 4 decimal
    public static void printResult(double num) {
        if (num % 1 == 0) {
            // integer
            System.out.println(Integer.valueOf("" + num));
        } else {
            // double
            System.out.printf("%.4f", Double.valueOf("" + num));
            System.out.println("");
        }
    }

    // ********************************************************* Add 4 possible 
    public static double add(double num1, double num2) {

        return (num1 + num2);
    }

    // *********************************************************  Subtract 4 possible
    public static double subtract(double num1, double num2) {
        return (num1 - num2);
    }

    // *********************************************************  Multiple 4 possible
    public static double multiply(double num1, double num2) {
        return (num1 * num2);
    }

    // *********************************************************  Divide 4 possible
    public static double divide(double num1, double num2) {
        return (num1 / num2);
    }

    public static double exponents(double base, double power) {
        double result = base;
        double counter = 0;

        // 3 possible, determine whether power is 0, >0, or <0
        if (power == 0) {
            return 1;
        } else if (power > 0) {
            counter = power - 1;
            for (int i = 0; i < counter; i++) {
                result *= base;
            }
            return result;
        } else {
            counter = (-power) - 1;
            for (int i = 0; i < counter; i++) {
                result *= base;
            }
            return (1 / result);
        }
    }

    public static double sqrt(double num) {
        return Math.sqrt(num);
    }

    public static double root(double num, double root) {
        return Math.pow(Math.E, Math.log(num) / root);
    }

    public static double modulus(double num1, double num2) {
        return (num1 % num2);
    }

    public static double factorials(double num) {
        double result = 1;

        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static double sin(double degree) {
        return Math.sin(Math.toRadians(degree));
    }

    public static double cos(double degree) {
        return Math.cos(Math.toRadians(degree));
    }

    public static double tan(double degree) {
        return Math.tan(Math.toRadians(degree));
    }

    public static void menu() {
        System.out.println("---------->>>>> Supported Operation & Syntax <<<<<----------");
        System.out.println("       1.  Addition:                     <num1> + <num2>");
        System.out.println("       2.  Subtraction:                  <num1> - <num2>");
        System.out.println("       3.  Multiply:                     <num1> * <num2>");
        System.out.println("       4.  Divide:                       <num1> / <num2>");
        System.out.println("       5.  Exponents:                    <num1> ^ <num2>");
        System.out.println("       6.  Modulus:                      <num1> % <num2>");
        System.out.println("       7.  Nth Root:                     <num1> nroot <num2>");
        System.out.println("       8.  Factorials:                   <num1> !");
        System.out.println("       9.  Square Root:                  sqrt <num1>");
        System.out.println("       10. sin():                        sin <num1 in degree>");
        System.out.println("       11. cos():                        cos <num1 in degree>");
        System.out.println("       12. tan():                        tan <num1 in degree>");
    }

    public static boolean isDouble(String s) {
        double n = 0;
        try {
            n = Double.valueOf(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean isInteger(String s) {
        int n = 0;
        try {
            n = Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
