import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

class Dog{
    String breed;
    int age;
    double weight;
}

public class GettingDataFromAFile{
    public static void main(String[] args) throws FileNotFoundException{
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        String fileName;
        Scanner input = new Scanner(System.in);
        Scanner fileScanner;


        System.out.print("Which file to open: ");
        fileName = input.nextLine();
        System.out.println("Reading data from " + fileName);


        /*
          Which file to open: dogs.txt
          Reading data from dogs.txt

          First dog: Yorkie, 4, 14
          Second dog: Great_Dane, 7, 93

         */
        fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        dog1.breed = fileScanner.nextLine();
        dog1.age = Integer.parseInt(fileScanner.nextLine());
        dog1.weight = Double.parseDouble(fileScanner.nextLine());
        dog2.breed = fileScanner.nextLine();
        dog2.age = Integer.parseInt(fileScanner.nextLine());
        dog2.weight = Double.parseDouble(fileScanner.nextLine());

        System.out.println("\nFirst dog: " + dog1.breed + ", " + dog1.age + ", " + dog1.weight);
        System.out.println("Secondg dog: " + dog2.breed + ", " + dog2.age + ", " + dog2.weight);
    }
}
