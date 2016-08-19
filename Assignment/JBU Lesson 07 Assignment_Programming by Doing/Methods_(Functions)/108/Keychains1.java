import java.util.Scanner;

public class Keychains1{
    public static void main(String[] args){
        int option = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ye Olde Keychain Shoppe");

        while(option!=89825153){
            System.out.println("\n1. Add Keychains to Order");
            System.out.println("2. Remove Keychains from Order");
            System.out.println("3. View Current Order");
            System.out.println("4. Checkout\n");
            System.out.print("Please enter your choice: ");
            option = scanner.nextInt();
            System.out.println("");

            switch (option){
            case 1:
                add_keychains();
                break;
            case 2:
                remove_keychains();
                break;
            case 3:
                view_order();
                break;
            case 4:
                checkout();
                option = 89825153;
                break;
            default:
                System.out.println("Invalid Input!\n");
            }
        }
    }

    public static void add_keychains(){
        System.out.println("ADD KEYCHAINS");
    }

    public static void remove_keychains(){
        System.out.println("REMOVE KEYCHAINS");
    }
    public static void view_order(){
        System.out.println("VIEW ORDER");
    }
    public static void checkout(){
        System.out.println("CHECKOUT");
    }
}
