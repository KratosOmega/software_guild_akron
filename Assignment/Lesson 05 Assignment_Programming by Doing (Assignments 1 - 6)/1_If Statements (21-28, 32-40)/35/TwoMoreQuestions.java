import java.util.Scanner;

public class TwoMoreQuestions{
    public static void main(String[] args){
        String clue1, clue2;
        Scanner scanner = new Scanner(System.in);

        System.out.println("TWO MORE QUESTIONS, BABY!/n");
        System.out.println("Think of something and I'll try to guess it!\n");

        System.out.print("Question 1) Does it stay inside or outside or both? ");
        clue1 = scanner.next();

        System.out.print("Question 2) Is it a living thing? ");
        clue2 = scanner.next();

        if (clue1.equals("inside") && clue2.equals("yes")){
            System.out.println("\n===> housepiant");
        }

        if (clue1.equals("inside") && clue2.equals("no")){
            System.out.println("\n===> shower curtain");
        }

        if (clue1.equals("outside") && clue2.equals("yes")){
            System.out.println("\n===> bison");
        }

        if (clue1.equals("outside") && clue2.equals("no")){
            System.out.println("\n===> billboard");
        }

        if (clue1.equals("both") && clue2.equals("yes")){
            System.out.println("\n===> dog");
        }

        if (clue1.equals("both") && clue2.equals("no")){
            System.out.println("\n===> cell phone");
        }
    }
}
