import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SummingSeveralNumbersFromAnyFile{
    public static void main(String[] args) throws FileNotFoundException{
        int sum = 0;
        String expression = "";
        int currentNum = 0;
        boolean beginning = true;
        String fileName;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which file would you like to read numbers from: ");
        fileName = scanner.next();

        Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));

        while(fileScanner.hasNextLine()){
            currentNum = Integer.parseInt(fileScanner.nextLine());
            sum += currentNum;
            if (beginning){
                expression += ("" + currentNum);
                beginning = false;
            }else{
                expression += (" + " + currentNum);
            }
        }

        System.out.println("Reading numbers from file \"3nums.txt\"... done.\n");
        System.out.println(expression + " = " + sum);
    }
}
