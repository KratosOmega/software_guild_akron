import java.util.Scanner;


class Student{
    String name;
    int grade;
    double average;

}


public class LilDatabaseLoop{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Student[] students = new Student[3];
        students[0] = new Student();
        students[1] = new Student();
        students[2] = new Student();

        for(int i = 0; i < students.length; i++){
            System.out.print("Enter the " + (i+1) + "'s student's name: ");
            students[i].name = input.next();
            System.out.print("Enter the " + (i+1) + "'s student's grade: ");
            students[i].grade = input.nextInt();
            System.out.print("Enter the " + (i+1) + "'s student's average: ");
            students[i].average = input.nextDouble();
            System.out.println("");
        }

        System.out.print("\nThe names are: ");
        for(int i = 0; i < students.length; i++){
            System.out.print(students[i].name + " ");
        }
        System.out.print("\nThe grades are: ");
        for(int i = 0; i < students.length; i++){
            System.out.print(students[i].grade + " ");
        }
        System.out.print("\nThe averages are: ");
        for(int i = 0; i < students.length; i++){
            System.out.print(students[i].average + " ");
        }

        System.out.println("\nThe average for the three students is: " + ((students[0].average + students[1].average + students[2].average) / 3));
    }
}
