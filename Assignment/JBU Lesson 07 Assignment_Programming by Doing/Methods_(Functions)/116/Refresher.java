import java.util.Scanner;

public class Refresher{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String name;

        System.out.print("What is you name: ");
        name = scanner.nextLine();
        System.out.println("");
        if(name.equals("Mitchell")){
            displayName(name, 5);
        }else{
            displayName(name, 10);
        }

    }

    public static void displayName(String name, int repeat){
        for (int i = 0; i < repeat; i++){
            System.out.println(name);
        }
    }
}
