
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class VowelCapitalization {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName;
        Scanner input = new Scanner(System.in);
        System.out.print("Open which file: ");
        fileName = input.nextLine();
        System.out.println("");
        System.out.println(fileFormater(fileName));

    }

    public static String fileFormater(String fileName) throws FileNotFoundException {
        Scanner fileScanner;
        String formatedFile = "";
        String fileContents = "";
        int counter = 0;
        int length = 0;
        char character = ' ';

        fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));

        while (fileScanner.hasNextLine()) {

            fileContents = fileScanner.nextLine();
            length = fileContents.toCharArray().length;
            while (counter < length) {

                //******** These lines below in comment gives me infinity loop issue
                //******** Need to figure out what's goning on
//                fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));
//                character = fileScanner.nextLine().charAt(counter);
                character = fileContents.charAt(counter); // this line is used to replace the 2 lines above

                if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                    character -= 32;
                }
                formatedFile += ("" + character);
                counter++;
            }
            formatedFile += ("\n");
            counter = 0;
        }
        return formatedFile;
    }
}
