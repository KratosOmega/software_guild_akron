import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

public class GradesInAnArrayAndAFile{
    public static void main(String[] args) throws IOException{
        String name = "";
        String fileName = "";
        int grade = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name (first last): ");
        name = scanner.nextLine();
        System.out.print("Filename: ");

        fileName = scanner.nextLine();
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));

        writer.println(name);

        System.out.println("\nHere are your randomly-selected grades (hope you pass):");
        for(int i = 1; i <= 5; i++){
            grade = 1 + random.nextInt(100);
            System.out.println("Grade "+ i +": " + grade);
            writer.print("" + grade + " "); // have to make the input as String, otherwise it will not write purely number
;
        }
        writer.flush();
        writer.close();

        System.out.println("\nData saved in \"" + fileName +"\".");
    }
}
