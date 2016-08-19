import java.util.Scanner;


class Student{
    String name;
    int grade;
    double average;

}


public class LilDatabase{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Student[] students = new Student[3];
        students[0] = new Student();
        students[1] = new Student();
        students[2] = new Student();

        System.out.print("Enter the first student's name: ");
        students[0].name = input.next();
        System.out.print("Enter the first student's grade: ");
        students[0].grade = input.nextInt();
        System.out.print("Enter the first student's average: ");
        students[0].average = input.nextDouble();

        System.out.print("\nEnter the second student's name: ");
        students[1].name = input.next();
        System.out.print("Enter the second student's grade: ");
        students[1].grade = input.nextInt();
        System.out.print("Enter the second student's average: ");
        students[1].average = input.nextDouble();

        System.out.print("\nEnter the third student's name: ");
        students[2].name = input.next();
        System.out.print("Enter the third student's grade: ");
        students[2].grade = input.nextInt();
        System.out.print("Enter the third student's average: ");
        students[2].average = input.nextDouble();

        System.out.println("\nThe names are: " + students[0].name + " " + students[1].name + " " + students[2].name);
        System.out.println("The grades are: " + students[0].grade + " " + students[1].grade + " " + students[2].grade);
        System.out.println("The averages are: " + students[0].average + " " + students[1].average + " " + students[2].average);


        System.out.println("The average for the three students is: " + ((students[0].average + students[1].average + students[2].average) / 3));
    }
}
