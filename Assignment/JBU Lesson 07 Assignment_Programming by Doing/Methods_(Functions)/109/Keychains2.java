
import java.util.Scanner;

public class Keychains2 {

    public static void main(String[] args) {
        int option = 0;
        int numOfKeychains = 0;
        int price = 10;
        String name;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ye Olde Keychain Shoppe");

        while (option != 89825153) {
            System.out.println("\n1. Add Keychains to Order");
            System.out.println("2. Remove Keychains from Order");
            System.out.println("3. View Current Order");
            System.out.println("4. Checkout\n");
            System.out.print("Please enter your choice: ");
            option = scanner.nextInt();
            System.out.println("");

            switch (option) {
                case 1:
                    numOfKeychains = add_keychains(numOfKeychains);
                    break;
                case 2:
                    numOfKeychains = remove_keychains(numOfKeychains);
                    break;
                case 3:
                    view_order(numOfKeychains, price);
                    break;
                case 4:
                    checkout(numOfKeychains, price);
                    option = 89825153;
                    break;
                default:
                    System.out.println("Invalid Input!\n");
            }
        }
    }

    public static int add_keychains(int numOfKeychains) {
        int numOfKey = numOfKeychains;
        int addNum;
        Scanner scanner = new Scanner(System.in);

        System.out.print("You have " + numOfKey + " keychains. How many to add? ");
        addNum = scanner.nextInt();
        numOfKey += addNum;
        System.out.println("You now have " + numOfKey + " keychains.\n");
        return numOfKey;
    }

    public static int remove_keychains(int numOfKeychains) {
        int numOfKey = numOfKeychains;
        int removeNum;
        Scanner scanner = new Scanner(System.in);

        System.out.print("You have " + numOfKey + " keychains. How many to remove? ");
        removeNum = scanner.nextInt();
        numOfKey -= removeNum;
        System.out.println("You now have " + numOfKey + " keychains.\n");
        return numOfKey;
    }

    public static void view_order(int numKeychains, int price) {
        System.out.println("You have " + numKeychains + " keychains.");
        System.out.println("Keychains cost $" + price + " each.");
        System.out.println("Total cost is $" + numKeychains * price + ".\n");
    }

    public static void checkout(int numKeychains, int price) {
        System.out.println("\nCHECKOUT\n");
        System.out.print("What is your name? ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        view_order(numKeychains, price);
    }
}
