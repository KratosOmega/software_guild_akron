import java.util.Scanner;

public class RightTriangleChecker_Nested_WhileLoop{
    public static void main(String[] args){
        int side1 = 0;
        int side2 = 0;
        int side3 = 0;
        int input;
        int sides = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three integers:");

        while (sides <= 3){
            System.out.print("Side " + sides + ": ");
            input = scanner.nextInt();

            switch (sides){
            case 1:
                while(input <= 0){
                    System.out.println("You can not enter a number that is negative or zero, please try agin!");
                    System.out.print("Side 1: ");
                    input = scanner.nextInt();
                }
                side1 = input;
                break;
            case 2:
                while (input < side1){
                    System.out.println(side2 + " is smaller than " + side1 + ". Try again.");
                    System.out.print("Side 2: ");
                    input = scanner.nextInt();
                }
                side2 = input;
                break;
            case 3:
                while (input < side2){
                    System.out.println(side3 + " is smaller than " + side2 + ". Try again.");
                    System.out.print("Side 3: ");
                    input = scanner.nextInt();
                }
                side3 = input;
                break;
            }

            sides++;
        }

        System.out.println("Your three sides are " + side1 + " " + side2 + " " + side3);

        if (side3 * side3 == (side1 * side1 + side2 * side2)){
            System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
        }else{
            System.out.println("NO!  These sides do not make a right triangle!");
        }
    }
}
