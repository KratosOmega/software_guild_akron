
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Person {

    String name;
    int age;
}

public class GettingMoreDataFromAFile {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Scanner fileReader;
        String fileName;
        Person[] people = new Person[5];

        for (int i = 0; i < people.length; i++) {
            people[i] = new Person();
        }

        System.out.print("Which file to open: ");
        fileName = input.nextLine();
        System.out.println("Reading data from " + fileName + "\n");

        fileReader = new Scanner(new BufferedReader(new FileReader(fileName)));

        for (int i = 0; i < people.length; i++) {
            people[i].name = fileReader.nextLine();
        }

        for (int i = 0; i < people.length; i++) {
            people[i].age = Integer.parseInt(fileReader.nextLine());
        }

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].name + " is " + people[i].age);
        }
    }
}
