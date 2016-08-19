import java.util.Scanner;

public class Adventure2
{
	public static void main( String[] args )
	{
		Scanner scanner = new Scanner(System.in);
		String nextroom = "Room-1";
    String choice = "";

    while (!nextroom.equals("Room-0")){
        switch (nextroom){
        case "Room-1":
            // => 2, => 3, => 4
            System.out.println("You are in Room-1!");
            System.out.println("Please choose which you want to go: \"Room-2\" or \"Room-3\" or \"Room-4\"");
            nextroom = scanner.nextLine();

            break;
        case "Room-2":
            // => 1, => 6
            System.out.println("You are in Room-2!");
            System.out.println("Please choose which you want to go: \"Room-1\" or \"Room-6\"");
            nextroom = scanner.nextLine();

            break;
        case "Room-3":
            // => 1, => 5
            System.out.println("You are in Room-3!");
            System.out.println("Please choose which you want to go: \"Room-1\" or \"Room-5\"");
            nextroom = scanner.nextLine();

            break;
        case "Room-4":
            // END !!!
            // => 1, => 6
            System.out.println("You are in Room-4!");
            System.out.println("Do you want to go to \"Next Room\" or \"Do Something\" here?");
            choice = scanner.nextLine();

            if (choice.equals("Next Room")){
                System.out.println("Please choose which you want to go: \"Room-1\" or \"Room-5\"");
                nextroom = scanner.nextLine();

            }else if (choice.equals("Do Something")){
                System.out.println("You are doing something and keep doing and you died because you are so tired...");
                nextroom = "Room-0";
            }else {
                System.out.println("Error!!!");
            }

            break;
        case "Room-5":
            // => 3, =>  6
            System.out.println("You are in Room-5!");
            System.out.println("Please choose which you want to go: \"Room-3\" or \"Room-6\"");
            nextroom = scanner.nextLine();

            break;
        case "Room-6":
            // END!!!
            // => 2, => 4, => 5
            System.out.println("You are in Room-6!");
            System.out.println("Do you want to go to \"Next Room\" or \"Sleep\" here?");
            choice = scanner.nextLine();

            if (choice.equals("Next Room")){
                System.out.println("Please choose which you want to go: \"Room-2\" or \"Room-4\" or \"Room-5\"");
                nextroom = scanner.nextLine();

            }else if (choice.equals("Sleep")){
                System.out.println("You had a good rest, let's call it a day!");
                nextroom = "Room-0";
            }else {
                System.out.println("Error!!!");
            }

            break;
        }
    }

		System.out.println( "\nEND." );
	}
	
}
