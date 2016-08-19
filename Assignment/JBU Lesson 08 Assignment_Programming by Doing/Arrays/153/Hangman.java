import java.util.Scanner;
import java.util.Random;

public class Hangman{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String againOrQuit = "again";

        while(againOrQuit.equals("again")){
            guessWord(prepareWord());

            System.out.print("\nPlay \"again\" or \"quit\"? ");
            againOrQuit = scanner.nextLine();
        }
    }


    // ---------------------------------------------------
    public static char[] prepareWord(){
        Random random = new Random();
        String[] wordList = {"morning","afternoon","evening"};
        String word = wordList[random.nextInt(wordList.length)];
        char[] wordInLetters = word.toCharArray();
        return wordInLetters;
    }

    // ---------------------------------------------------
    public static void guessWord(char[] wordInLetters){
        Scanner scanner = new Scanner(System.in);
        boolean[] checkList = new boolean[wordInLetters.length];
        int missedCounts = 0;
        String missedLetters = "";
        char guess = ' ';
        boolean miss = true;
        int corrects = wordInLetters.length;

        // Set up the answer list
        boolean[] answer = new boolean[wordInLetters.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = true;
        }

        // repeat game until got all right or missed 5 times
        while(missedCounts < 5){
            displayStatus(checkList, wordInLetters, missedLetters, corrects);

            guess = scanner.next().charAt(0);

            for(int i = 0; i < wordInLetters.length; i++){
                if(!checkList[i]){
                    if(guess == wordInLetters[i]){
                        checkList[i] = true;
                        miss = false;
                        corrects--;
                    }
                }
            }

            if(miss){
                missedCounts++;
                missedLetters += ("" + guess);
            }else{
                miss = true;
            }

            if(missedCounts == 5){
                displayStatus(answer, wordInLetters, missedLetters, corrects);
            }else if (corrects == 0){
                displayStatus(answer, wordInLetters, missedLetters, corrects);
                missedCounts = 5;
            }
        }
    }


    // ---------------------------------------------------
    public static void displayStatus(boolean[] checkList, char[] wordInLetters, String missedLetters, int corrects){
        System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        System.out.print("Word: ");
        for(int i = 0; i < checkList.length; i++){
            if(checkList[i]){
                System.out.print(wordInLetters[i] + " ");
            }else{
                System.out.print("- ");
            }
        }
        System.out.println("\n\nMisses: " + missedLetters);
        if(missedLetters.toCharArray().length == 5){
            System.out.println("\nYou used up all 5 chances, you lost!");
        }else if (corrects == 0){
            System.out.println("\n\nYou got it all right, you win!");
        }else{
            System.out.print("\nGuess: ");
        }
    }
}
