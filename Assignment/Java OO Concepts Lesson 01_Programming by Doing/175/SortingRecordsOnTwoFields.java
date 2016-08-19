
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

class Student {

    int id;
    int gradeNum;
    double grade;
    String letterGrade;
}

public class SortingRecordsOnTwoFields {

    public static void main(String[] args) throws FileNotFoundException {
        int startAt = 0;
        int endAt;
        boolean keepGoing = true;
        Scanner input = new Scanner(System.in);
        Scanner fileReader;
        String fileName;
        Student[] students = new Student[30];
        int repeat = students.length;
        Student temp;

        System.out.print("Open which file: ");
        fileName = input.next();
        System.out.println("\nData loaded.");
        System.out.println("Data sorted.\n");
        System.out.println("Here are the sorted grades:");
        fileReader = new Scanner(new BufferedReader(new FileReader(fileName)));

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].id = Integer.parseInt(fileReader.next());
            students[i].gradeNum = Integer.parseInt(fileReader.next());
            students[i].grade = Double.parseDouble(fileReader.next());
            students[i].letterGrade = fileReader.next();
        }

        while (repeat > 1) {
            for (int i = 0; i < repeat - 1; i++) {
                if (students[i].id > students[i + 1].id) {
                    temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                }
            }
            repeat--;
        }

        endAt = findBoundary(startAt, students);
        while (keepGoing) {
            sortArray(startAt, endAt, students);

            if (endAt == students.length) {
                keepGoing = false;
            } else {
                startAt = endAt + 1;
                endAt = findBoundary(startAt, students);
            }
        }

        for (Student s : students) {
            System.out.println("\t" + s.id + " " + s.gradeNum + " " + s.grade + " " + s.letterGrade);
        }
    }

    public static int findBoundary(int startAt, Student[] students) {
        for (int i = startAt; i < students.length - 1; i++) {
            if (students[i] != students[i + 1]) {
                return i;
            }
        }
        return students.length;
    }

    public static void sortArray(int startAt, int endAt, Student[] students) {
        int repeat = endAt - startAt;
        Student temp = new Student();

        while (repeat > 0) {
            for (int i = startAt; i < endAt - 1; i++) {
                if (students[i].gradeNum > students[i + 1].gradeNum) {
                    temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                }
            }
            repeat--;
        }
    }
}
