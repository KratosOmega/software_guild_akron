import java.util.Scanner;

public class BabyCalculator
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);

		double a, b, c;
		String op;

		do
		{
			System.out.print("> ");
			a  = keyboard.nextDouble();
			op = keyboard.next();
			b  = keyboard.nextDouble();

      if (a == 0){
          System.out.println("Bye, now.");
          break;
      }

      switch (op){
      case "+":
          c = add(a,b);
          break;
      case "-":
          c = subtract(a,b);
          break;
      case "*":
          c = multiply(a,b);
          break;
      case "/":
          c = divide(a,b);
          break;
      default:
          System.out.println("Undefined operator: '" + op + "'.");
          c = 0;
      }

			System.out.println(c);
		} while ( true );
	}

    public static double add (double num1, double num2){
        return (num1 + num2);
    }
    public static double subtract (double num1, double num2){
        return (num1 - num2);
    }
    public static double multiply (double num1, double num2){
        return (num1 * num2);
    }
    public static double divide (double num1, double num2){
        return (num1 / num2);
    }
}

