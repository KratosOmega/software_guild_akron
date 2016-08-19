import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HighScore{
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(new FileWriter("score.txt"));
        int score;
        String name;

        System.out.println("You got a high score!");
        System.out.print("Please enter your score: ");
        score = scanner.nextInt();
        System.out.print("Please enter your name: ");
        name = scanner.next();
        System.out.println("");

        printWriter.println(name + " has a score of " + score);
        printWriter.flush();
        printWriter.close();
    }
}
