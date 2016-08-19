import java.util.Scanner;

public class RightTriangleChecker{
    public static void main(String[] args){
        int side1, side2, side3;
        int sides = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three integers:");
        System.out.print("Side 1: ");
        side1 = scanner.nextInt();

        while (side1 <= 0){
            System.out.println("You can't enter a number that is negative or zero for side 1. Try again.");
            System.out.print("Side 1: ");
            side1 = scanner.nextInt();
        }


        System.out.print("Side 2: ");
        side2 = scanner.nextInt();

        while (side2 < side1){
            System.out.println(side2 + " is smaller than " + side1 + ". Try again.");
            System.out.print("Side 2: ");
            side2 = scanner.nextInt();
        }


        System.out.print("Side 3: ");
        side3 = scanner.nextInt();

        while (side3 < side1){
            System.out.println(side3 + " is smaller than " + side2 + ". Try again.");
            System.out.print("Side 3: ");
            side3 = scanner.nextInt();
        }

        System.out.println("Your three sides are " + side1 + " " + side2 + " " + side3);



        if (side3 * side3 == (side1 * side1 + side2 * side2)){
            System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
        }else{
            System.out.println("NO!  These sides do not make a right triangle!");
        }
    }
}
