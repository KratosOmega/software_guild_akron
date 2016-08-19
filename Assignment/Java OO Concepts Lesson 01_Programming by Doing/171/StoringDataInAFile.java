import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

class Car{
    String make;
    String model;
    int year;
    String license;
}


public class StoringDataInAFile{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        String fileName;
        PrintWriter fileWriter;

        Car[] cars = new Car[5];
        for(int i = 0; i < cars.length; i++){
            cars[i] = new Car();
            System.out.println("Car " + (i + 1));
            System.out.print("        Make: ");
            cars[i].make = input.next();
            System.out.print("        Model: ");
            cars[i].model = input.next();
            System.out.print("        Year: ");
            cars[i].year = Integer.parseInt(input.next());
            System.out.print("        License: ");
            cars[i].license = input.next();
            System.out.println(cars[i].make + " " + cars[i].model + " " + cars[i].year + " " + cars[i].license);
        }

        System.out.print("To which file do you want to save this information? ");
        fileName = input.next();
        fileWriter = new PrintWriter(new FileWriter(fileName));


        for(int i = 0; i < cars.length; i++){
            fileWriter.println(cars[i].make + " " + cars[i].model + " " + cars[i].year + " " + cars[i].license);
        }

        System.out.println("Data saved.");

        fileWriter.flush();
        fileWriter.close();
    }
}
