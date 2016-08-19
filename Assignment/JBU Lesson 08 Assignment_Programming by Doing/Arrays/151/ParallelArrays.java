import java.util.Scanner;

public class ParallelArrays{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int idFinder;
        String[] lastName = {"Mitchell", "Ortiz", "Luu", "Zimmerman", "Brooks"};
        double[] grade = {99.5, 78.5, 95.6, 96.8, 82.7};
        int[] id = {123456, 813225, 823669, 307760, 827131};


        System.out.println("Values:");
        for (int i = 0; i < lastName.length; i++){
            System.out.println("\t" + lastName[i] + " " + grade[i] + " " + id[i]);
        }

        System.out.print("\nID number to find: ");
        idFinder = scanner.nextInt();

        for (int i = 0; i < id.length; i ++){
            if (idFinder == id[i]){
                System.out.println("\nFound in slot " + (i+1));
                System.out.println("\tName: " + lastName[i]);
                System.out.println("\tAverage: " + grade[i]);
                System.out.println("\tID: " + id[i]);
            }
        }
    }
}
