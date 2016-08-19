/*
 * Q1: "n++" is as same as "n = n + 1", which will add 1 to n each time "n++" is called. Remove "n++" in this program will cause an infinity loop
 * Q2: Change "while (n < 5)" to "while (n < 10)" will change the loop to repeat 10 times.
 * Q3: Change "n+1" to "n*10+10"
 * Q4: Codes are edited base on requirements
 */

import java.util.Scanner;

public class CountingWhile
{
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);
        int roundRepeat;

        System.out.println( "Type in a message, and I'll display it five times." );
        System.out.print( "Message: " );
        String message = keyboard.nextLine();
        System.out.print("How many time? ");
        roundRepeat = keyboard.nextInt();

        int n = 0;
        while ( n < roundRepeat ){
            System.out.println( (n*10+10) + ". " + message );
            n++;
        }
    }
}

