import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SummingThreeNumbersFromAFile{
    public static void main(String[] args) throws FileNotFoundException{
        int sum = 0;
        String expression = "";
        int currentNum = 0;
        boolean beginning = true;
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("3nums.txt")));

        while(scanner.hasNextLine()){
            currentNum = Integer.parseInt(scanner.nextLine());
            sum += currentNum;
            if (beginning){
                expression += ("" + currentNum);
                beginning = false;
            }else{
                expression += (" + " + currentNum);
            }
        }

        System.out.println("Reading numbers from file \"3nums.txt\"... done.");
        System.out.println(expression + " = " + sum);
    }
}
