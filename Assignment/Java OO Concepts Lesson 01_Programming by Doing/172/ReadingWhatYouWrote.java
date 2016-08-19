import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


class Car{
    String make;
    String model;
    int year;
    String license;
}


public class ReadingWhatYouWrote{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        Scanner fileReader;
        String fileName;
        System.out.print("From which file do you want to load this information? ");
        fileName = input.next();
        System.out.println("Data Loaded...\n");

        fileReader = new Scanner(new BufferedReader(new FileReader(fileName)));
        Car[] cars = new Car[5];

        for(int i = 0; i < cars.length; i++){
            cars[i] = new Car();
            cars[i].make = fileReader.next();
            cars[i].model = fileReader.next();
            cars[i].year = Integer.parseInt(fileReader.next());
            cars[i].license = fileReader.next();
            //fileReader.skip("\n");  //??? what does ".skip()" do?

            System.out.println("Car " + (i+1));
            System.out.println("\tMake: " + cars[i].make);
            System.out.println("\tModel: " + cars[i].model);
            System.out.println("\tYear: " + cars[i].year);
            System.out.println("\tLicense: " + cars[i].license + "\n\n");
        }
    }
}
