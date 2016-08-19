/*
 * Q1: "n = n + 1" will increase the value of n to make it reach the stopper.
 * Q2: "int n = 1" will initialize the "n", so it can be started to use as a counter.
 *
 */


import java.util.Scanner;

public class CountingFor
{
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println( "Type in a message, and I'll display it five times." );
        System.out.print( "Message: " );
        String message = keyboard.nextLine();

        for ( int n = 2 ; n <= 10 ; n = n+2 )
            {
                System.out.println( n + ". " + message );
            }

    }
}
