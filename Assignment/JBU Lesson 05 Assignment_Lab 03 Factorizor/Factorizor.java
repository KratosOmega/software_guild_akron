import java.util.Scanner;

public class Factorizor{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num;
        int perfectSum = 0;
        int primeCount = 0;

        System.out.print("What number would you like to factor? ");
        num = scanner.nextInt();
        System.out.println("\nThe factors of " + num + " are: \n");

        for(int i = 1; i < num; i++){
            if(num % i == 0){
                System.out.println(i +"\n");
                primeCount++;
                perfectSum += i;
            }
        }

        if (perfectSum == num){
            System.out.println(num + " is a perfect number\n");
        }else{
            System.out.println(num + " is not a perfect number\n");
        }

        if (primeCount == 1){
            System.out.println(num + " is a prime number\n");
        }else{
            System.out.println(num + " is not a prime number\n");
        }
    }
}
