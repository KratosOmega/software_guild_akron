import java.util.Scanner;

public class InterestCalculator{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double annualRate;
        double principal;
        double currentBalance;
        double years;
        String calculate = "";
        String compoundOption = "";
        int annualPeriods = 0;
        String start;
        String reportFormat = "";

        System.out.println("$$$$$$$$$$$&$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$                                    $$$$$$$");
        System.out.println("$$$$$$$>   Kratos's Interest Calculator   <$$$$$$$");
        System.out.println("$$$$$$$                                    $$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$                                    $$$$$$$");
        System.out.print("$$$$$$$ Annual Interest Rate : [         ] $$$$$$$\r$$$$$$$ Annual Interest Rate : [   ");
        annualRate = scanner.nextDouble();
        System.out.print("$$$$$$$ Initial Principal    : [         ] $$$$$$$\r$$$$$$$ Initial Principal    : [ ");
        principal = scanner.nextDouble();
        System.out.print("$$$$$$$ # of Years in fund   : [         ] $$$$$$$\r$$$$$$$ # of Years in fund   : [ ");
        years = scanner.nextDouble();
        System.out.print("$$$$$$$ Peiod Type: Q/ M/ D  : [         ] $$$$$$$\r$$$$$$$ Peiod Type: Q/ M/ D  : [    ");
        compoundOption = scanner.next();
        System.out.println("$$$$$$$                                    $$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$                                    $$$$$$$");
        System.out.println("$$$$$$$         +----------------+         $$$$$$$");
        System.out.println("$$$$$$$         |      Start     |         $$$$$$$");
        System.out.println("$$$$$$$         +----------------+         $$$$$$$");
        System.out.println("$$$$$$$                                    $$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.print("$$$$$$$$$$$$$$$$$$$$$$<     >$$$$$$$$$$$$$$$$$$$$$\r$$$$$$$$$$$$$$$$$$$$$$<");
        start = scanner.next();
        System.out.println("");

        // Update current balance
        currentBalance = principal;

        // Determine periods #
        switch(compoundOption){
        case "Q":
            annualPeriods = 4;
            break;
        case "M":
            annualPeriods = 12;
            break;
        case "D":
            annualPeriods = 365;
            break;
        default:
            System.out.println("No Such Option!!!");
        }

        System.out.println("\n\n-------------------------------------------------");

        int counter = 0;

        while (years > 0){
            counter++;
            if(years < 1){
                double lastPeriods = annualPeriods * years;
                double beginningBalance = currentBalance;
                for(int i = 0; i < lastPeriods; i++){
                    currentBalance = currentBalance * (1 + (annualRate/annualPeriods)/100);
                }
                System.out.println("Year #: " + counter);
                System.out.print("The Beginning Balance: ");
                System.out.printf("%.2f", beginningBalance);
                System.out.print("\nTotal interest earned during the year: ");
                System.out.printf("%.2f", (currentBalance - beginningBalance));
                System.out.print("\nThe Ending Balnace: ");
                System.out.printf("%.2f", currentBalance);
                System.out.println("\n-------------------------------------------------");
            }else{
                double beginningBalance = currentBalance;
                for(int i = 0; i < annualPeriods; i++){
                    currentBalance = currentBalance * (1 + (annualRate/annualPeriods)/100);
                }
                System.out.println("Year #: " + counter);
                System.out.print("The Beginning Balance: ");
                System.out.printf("%.2f", beginningBalance);
                System.out.print("\nTotal interest earned during the year: ");
                System.out.printf("%.2f", (currentBalance - beginningBalance));
                System.out.print("\nThe Ending Balnace: ");
                System.out.printf("%.2f", currentBalance);
                System.out.println("\n-------------------------------------------------");
            }
            years--;
        }
    }
}
