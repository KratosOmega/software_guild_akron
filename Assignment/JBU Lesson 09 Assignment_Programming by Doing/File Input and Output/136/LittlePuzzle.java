import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LittlePuzzle{
    public static void main(String[] args) throws FileNotFoundException{
        int counter = 2;
        Scanner fileScanner;
        Scanner input = new Scanner(System.in);
        String fileName;
        String fileContents = "";
        char third = ' ';
        int length = 0;

        System.out.print("Open which file: ");
        fileName = input.nextLine();

        fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));

        while(fileScanner.hasNextLine()){
            fileContents = fileScanner.nextLine();
            length = fileContents.toCharArray().length;
            while(counter < length){
                third = fileContents.charAt(counter);
                System.out.print(third);
                counter += 3;
            }
            System.out.println("");
            counter = 2;
        }
    }
}
