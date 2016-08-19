/*
You will need 3 new variables in main, one to store the sales tax (8.25%), one to store the shipping cost per order ($5.00), and one to store the additional per keychain shipping cost ($1.00).

view_order() will need to be passed the three additional variables, a total of five, and have a return type of void. It will display, on different lines,




checkout() will need to be passed the same values as view_order(), and have a return type of void. It will ask the user for his/her name in order to deliver them correctly, then call view_order() to display the order information, and then thank the user, by name, for ordering.
 */

import java.util.Scanner;

public class Keychains3 {

    public static void main(String[] args) {
        double tax = 0.0825;
        int shippingCost = 5;
        int additionalShippingFee = 1;
        int option = 0;
        int numOfKeychains = 0;
        double price = 10.00;
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
                    view_order(numOfKeychains, price, tax, shippingCost, additionalShippingFee);
                    break;
                case 4:
                    checkout(numOfKeychains, price, tax, shippingCost, additionalShippingFee);
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
        while(removeNum > numOfKey){
            System.out.print("You don't have that many keychains in order, please re-enter... ");
            removeNum = scanner.nextInt();
        }
        numOfKey -= removeNum;
        System.out.println("You now have " + numOfKey + " keychains.\n");
        return numOfKey;
    }

    public static void view_order(int numKeychains, double price_per_keychain, double taxRate, int base_shipping, int per_keychain_shipping) {
        double shipmentCost = numKeychains * per_keychain_shipping + base_shipping;
        double subtotal = numKeychains * per_keychain_shipping + base_shipping + numKeychains * price_per_keychain;
        double tax = subtotal * taxRate;
        double finalTotal = tax + subtotal;
        System.out.println("You have " + numKeychains + " keychains.");
        System.out.println("Keychains cost $" + price_per_keychain + " each.");
        System.out.println("The shipment cost $ " + shipmentCost + " totally.");
        System.out.println("The subtotal before tax is $ " + subtotal + ".");
        System.out.println("The tax on the order is $ " + tax);
        System.out.println("The final cost of the order is $" + finalTotal + ".\n");
    }

    public static void checkout(int numKeychains, double price_per_keychain, double tax, int base_shipping, int per_keychain_shipping){
        String name;
        System.out.println("\nCHECKOUT\n");
        System.out.print("What is your name? ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();

        view_order(numKeychains, price_per_keychain, tax, base_shipping, per_keychain_shipping);
        System.out.println("Thank you for your order, " + name + " and you have a nice day!");
    }
}
