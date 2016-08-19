/*
 * Q1: "r.nextInt(5)" will only return whole number within 0 ~ 4.
 * Q2: "3 + r.nextInt(5)" will not return whole number within 3 ~ 5, instead, it returns whole number within in 3 ~ 7.
 * Q3: The random number series are generated in the same sequence every time run the execution. Although the series is still random. It is like the "seed" is used as a ID for the randome instance.
 * Q4: The random number series are still generated in the same sequence every time run the execution. However, since the seed is change, the combination of randomness is changed too.
 * Q5: Seed is removed.
 */


import java.util.Random;

public class Randomness {

    public static void main(String[] args) {
        Random r = new Random();

        int x = 1 + r.nextInt(10);

        System.out.println("My random number is " + x);

        System.out.println("Here are some numbers from 1 to 5!");
        System.out.print(3 + r.nextInt(5) + " ");
        System.out.print(3 + r.nextInt(5) + " ");
        System.out.print(3 + r.nextInt(5) + " ");
        System.out.print(3 + r.nextInt(5) + " ");
        System.out.print(3 + r.nextInt(5) + " ");
        System.out.print(3 + r.nextInt(5) + " ");
        System.out.println();

        System.out.println("Here are some numbers from 1 to 100!");
        System.out.print(1 + r.nextInt(100) + "\t");
        System.out.print(1 + r.nextInt(100) + "\t");
        System.out.print(1 + r.nextInt(100) + "\t");
        System.out.print(1 + r.nextInt(100) + "\t");
        System.out.print(1 + r.nextInt(100) + "\t");
        System.out.print(1 + r.nextInt(100) + "\t");
        System.out.println();

        int num1 = 1 + r.nextInt(10);
        int num2 = 1 + r.nextInt(10);

        if (num1 == num2) {
            System.out.println("The random numbers were the same! Weird.");
        }
        if (num1 != num2) {
            System.out.println("The random numbers were different! Not too surprising, actually.");
        }
    }
}
