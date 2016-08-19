import java.util.Scanner;

public class AreaCalculator{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int shape = 0;
        int base, height, length, width, side, radius;

        while (shape != 5){
            if (shape == 0){
                System.out.println("Shape Area Calculator version 0.1 (c) 2005 Mitchell Sample Output, Inc.\n");
            }

            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
            System.out.println("1) Triangle");
            System.out.println("2) Rectangle");
            System.out.println("3) Square");
            System.out.println("4) Circle");
            System.out.println("5) Quit");
            System.out.print("Which shape: ");
            shape = scanner.nextInt();
            System.out.println("");

            switch (shape){
            case 1:
                System.out.print("Base: ");
                base = scanner.nextInt();
                System.out.print("Height: ");
                height = scanner.nextInt();
                System.out.println("The area is " + area_triangle(base, height) + ".");
                break;
            case 2:
                System.out.print("Length: ");
                length = scanner.nextInt();
                System.out.print("Width: ");
                width = scanner.nextInt();
                System.out.println("The area is " + area_rectangle(length, width) + ".");
                break;
            case 3:
                System.out.print("Side: ");
                side = scanner.nextInt();
                System.out.println("The area is " + area_square(side) + ".");
                break;
            case 4:
                System.out.print("Radius: ");
                radius = scanner.nextInt();
                System.out.println("The area is " + area_circle(radius) + ".");
                break;
            case 5:
                shape = 5;
                System.out.println("Thank you for using Shape Area Calculater! Good Bye!!!");
                break;
            default:
                System.out.println("Invalid Selection, please try again...");
            }
        }
    }

    // ************** Methods *****************

    // returns the area of a circle
    public static double area_circle( int radius )
    {
        return Math.PI * radius * radius;
    }
    // returns the area of a rectangle
    public static int area_rectangle( int length, int width ){
        return length * width;
    }
    // returns the area of a square
    public static int area_square( int side ){
        return side * side;
    }
    // returns the area of a triangle
    public static double area_triangle( int base, int height ){
        return base * height / 2.0;
    }
}
