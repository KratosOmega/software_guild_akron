
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimpleFileInput{
    public static void main(String[] args) throws FileNotFoundException{
        read();
    }

    public static void read() throws FileNotFoundException{
        String currentLine;
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("name.txt")));

        System.out.println("Using my psychic powers (aided by reading data from the file), I have");
        System.out.print("determined that your name is ");

        while (scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            System.out.print(currentLine);
        }
        System.out.println(".");
    }
}
