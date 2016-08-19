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

public class SortingStrings{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        Scanner fileReader;
        String fileName;
        int repeat;
        Car temp = new Car();

        System.out.print("From which file do you want to load this information? ");
        fileName = input.next();
        System.out.println("Data Loaded...\n");

        fileReader = new Scanner(new BufferedReader(new FileReader(fileName)));
        Car[] cars = new Car[5];
        repeat = cars.length;

        for(int i = 0; i < cars.length; i++){
            cars[i] = new Car();
            cars[i].make = fileReader.next();
            cars[i].model = fileReader.next();
            cars[i].year = Integer.parseInt(fileReader.next());
            cars[i].license = fileReader.next();
            //fileReader.skip("\n");  //??? what does ".skip()" do?
        }

        while(repeat > 1){
            for(int i = 0; i < repeat-1; i++){
                if(cars[i].make.compareTo(cars[i+1].make) > 0){
                    temp = cars[i];
                    cars[i] = cars[i+1];
                    cars[i+1] = temp;
                }
            }
            repeat--;
        }

        for(int i = 0; i < cars.length; i++){
            System.out.println("Car " + (i+1));
            System.out.println("\tMake: " + cars[i].make);
            System.out.println("\tModel: " + cars[i].model);
            System.out.println("\tYear: " + cars[i].year);
            System.out.println("\tLicense: " + cars[i].license + "\n\n");
        }
    }
}
