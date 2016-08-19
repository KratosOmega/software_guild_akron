import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DisplayingAFile {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Scanner fileScanner;
        String fileName;

        System.out.print("Open which file: ");
        fileName = input.nextLine();
        fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        System.out.println("");

        while(fileScanner.hasNextLine()){
            System.out.println(fileScanner.nextLine());
        }
    }
}
