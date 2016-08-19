/*
 * Q1: "while" loop is similiar to "if" statement for both doing the true or false validation.
 * Q2: "while" loop is different from "if" statement for doing true of false validation repeatly, but "if" statement only do the validation once.
 * Q3: Because "entry" has been declared as "int" already, and it is a instance variable, not block variable.
 * Q4: It cause a infinity loop, as long as we enter an invalid password at the beginning. Since re-enter password option is not provided, it will loop infinitely to say we enter wrong password.
 * Q5: Put the entry = keyboard.nextInt(); back
 */

import java.util.Scanner;

public class EnterPIN
{
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);
        int pin = 12345;

        System.out.println("WELCOME TO THE BANK OF MITCHELL.");
        System.out.print("ENTER YOUR PIN: ");
        int entry = keyboard.nextInt();

        while ( entry != pin )
            {
                System.out.println("\nINCORRECT PIN. TRY AGAIN.");
                System.out.print("ENTER YOUR PIN: ");
                entry = keyboard.nextInt();
            }

        System.out.println("\nPIN ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT.");
    }
}
