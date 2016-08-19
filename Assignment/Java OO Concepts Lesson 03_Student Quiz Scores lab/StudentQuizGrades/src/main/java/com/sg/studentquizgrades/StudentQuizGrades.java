/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Kratos
 */
public class StudentQuizGrades {

    private HashMap<String, ArrayList<Double>> studentRecords;

    public StudentQuizGrades() {
        this.studentRecords = new HashMap<>();
    }

    public static void main(String[] args) {
        StudentQuizGrades quizSystem = new StudentQuizGrades();
        quizSystem.launchSystem();
    }

    // -------------------------------------------------------------------------- Basic functionalities
    // View a list of students in the system
    public void viewStudents(StudentQuizGrades studentRecords) {
        ConsoleIOCalculator console = new ConsoleIOCalculator();

        if (studentRecords.getStudentRecords().size() > 0) {
            Set<String> studentNameList = studentRecords.getStudentRecords().keySet();

            console.display("\n  --------->>> Student List <<<-------  \n");
            for (String name : studentNameList) {
                console.display("  - " + name + "\n");
            }
        } else {
            console.display("\n******************************************\n");
            console.display("*      No records in the database!       *\n");
            console.display("*   Please select [2] to add records.    *\n");
            console.display("******************************************\n");
        }
    }

    // Add a student to the system
    public boolean addStudent(StudentQuizGrades studentRecords) {
        ConsoleIOCalculator console = new ConsoleIOCalculator();
        String studentName;
        ArrayList<Double> quizs = new ArrayList<>();
        int quizCounter = 0;
        double score;

        String update = ""; // Add

        console.display("\n  --------->>> Add Student <<<---------    \n");

        studentName = console.promptForString("> Enter student name: ");

        if (findStudentRecord(studentRecords, studentName)) {
            console.display("\n" + studentName + "'s record is already in the database.\n");
            console.display("(\"update\" - Update New Score / \"quit\" - Quit Editing)\n");
            if (console.promptForString("\nSelect your action: ").equals("update")) {
                quizCounter = studentRecords.getStudentRecords().get(studentName).size();
                quizs = studentRecords.getStudentRecords().get(studentName);

                while (true) {
                    quizCounter++;
                    score = console.promptForDoubleWithinRange("> Enter score for Quiz " + quizCounter + ": ", -1, 100);
                    if (score < 0) {
                        break;
                    } else {
                        quizs.add(score);
                    }
                }
                studentRecords.getStudentRecords().put(studentName, quizs);
                return true;
            } else {
                console.display("Searching record is not founded in the database");
                return false;
            }
        } else {
            console.display("\n******************************************\n");
            console.display("*  Enter score (0 ~ 100) for each quiz.  *\n");
            console.display("* Invalid score ( > 100) will be denied. *\n");
            console.display("*    Enter \"-1\" for score to quit...     *\n");
            console.display("******************************************\n\n");
            while (true) {
                quizCounter++;
                score = console.promptForDoubleWithinRange("> Enter score for Quiz " + quizCounter + ": ", -1, 100);
                if (score < 0) {
                    break;
                } else {
                    quizs.add(score);
                }
            }

            // if the first quiz was entered as negative
            // Student record should not be created at all
            if (quizCounter == 1 && score < 0) {
                return false;
            } else {
                studentRecords.getStudentRecords().put(studentName, quizs);
                return true;
            }
        }
    }

    // Remove a student from the system
    public boolean removeStudent(StudentQuizGrades studentRecords) {
        ConsoleIOCalculator console = new ConsoleIOCalculator();
        String studentName;

        console.display("\n  -------->>> Remove Student <<<--------   \n");

        studentName = console.promptForString("> Enter student name: ");

        if (studentRecords.getStudentRecords().size() == 0) {
            console.display("******************************************\n");
            console.display("*      No records in the database!       *\n");
            console.display("*   Please select [2] to add records.    *\n");
            console.display("******************************************\n");
            return false;
        } else if (findStudentRecord(studentRecords, studentName)) {
            studentRecords.getStudentRecords().remove(studentName);
            console.display("\n" + studentName + "'s record is successfully deleted!\n");
            return true;
        } else {
            console.display("\n" + studentName + "'s record is not found in the database.\n");
            console.display("Please select [2] to add his/her record...\n");
            return false;
        }
    }

    // View a list of quiz scores for a given student
    public void viewQuiz(StudentQuizGrades studentRecords) {
        ConsoleIOCalculator console = new ConsoleIOCalculator();
        String studentName;
        int quizCounter = 0;

        console.display("\n  ----->>> View Student's Quizs <<<-----\n");
        studentName = console.promptForString("> Enter student name: ");
        if (findStudentRecord(studentRecords, studentName)) {
            ArrayList<Double> quizs = studentRecords.getStudentRecords().get(studentName);
            console.display("\n  " + studentName + "'s Quiz scores:\n");

            for (double score : quizs) {
                quizCounter++;
                console.display("  - Quiz " + quizCounter + ": " + score + "\n");
            }
        } else {
            console.display("\n******************************************\n");
            console.display("*   No record is found, action failed!   *\n");
            console.display("******************************************\n\n");
        }
    }

    // View the average quiz score for a given student
    public void quizAvg(StudentQuizGrades studentRecords) {

        ConsoleIOCalculator console = new ConsoleIOCalculator();
        String studentName;

        double sum = 0;

        console.display("\n----->>> View Student's Average <<<-----\n");
        studentName = console.promptForString("> Enter student name: ");

        if (findStudentRecord(studentRecords, studentName)) {
            ArrayList<Double> quizs = studentRecords.getStudentRecords().get(studentName);
            console.display("> " + studentName + "'s Quiz Average: ");

            for (double score : quizs) {
                sum += score;
            }

            console.display("" + toTwoDecimal(sum / quizs.size()) + "\n");
        } else {
            console.display("\n******************************************\n");
            console.display("*   No record is found, action failed!   *\n");
            console.display("******************************************\n\n");
        }
    }

    public void launchSystem() {
        ConsoleIOCalculator console = new ConsoleIOCalculator();
        String opration;
        boolean firstLaunch = true;

        menu();

        while (true) {
            if (firstLaunch) {
                opration = console.promptForString("\nSelect your action: ");
                firstLaunch = false;
            } else {
                console.display("\n<><><><><><><> Operion Done <><><><><><><>\n");
                opration = console.promptForString("\nSelect your action: ");
            }

            if (opration.equals("9") || opration.equals("quit")) {
                console.display("\n<><><><><><><> Operion Done <><><><><><><>\n");
                console.display("\n                 Thank you                  ");
                break;
            } else {
                action(opration);
            }
        }
    }

    public void action(String option) {
        ConsoleIOCalculator console = new ConsoleIOCalculator();

        switch (option) {
            case "0":
                menu();
                break;
            case "1":
                viewStudents(this);
                break;
            case "2":
                addStudent(this);
                break;
            case "3":
                removeStudent(this);
                break;
            case "4":
                viewQuiz(this);
                break;
            case "5":
                quizAvg(this);
                break;
            case "6":
                classAverage(this);
                break;
            case "7":
                findHighestQuizRecord(this);
                break;
            case "8":
                findLowestQuizRecord(this);
                break;
            default:
                console.display("Invalid Option!!!\n");
        }
    }

    // -------------------------------------------------------------------------- Extension 
    public double classAverage(StudentQuizGrades studentRecords) {
        ConsoleIOCalculator console = new ConsoleIOCalculator();

        double sum = 0;
        int quizCounter = 0;

        if (studentRecords.getStudentRecords().size() > 0) {
            Set<String> studentNameList = studentRecords.getStudentRecords().keySet();

            for (String name : studentNameList) {
                for (double score : studentRecords.getStudentRecords().get(name)) {
                    sum += score;
                    quizCounter++;
                }
            }

            console.display("> Class quiz average is: " + toTwoDecimal(sum / quizCounter));
            return sum / quizCounter;
        } else {
            console.display("\n******************************************\n");
            console.display("*      No records in the database!       *\n");
            console.display("*   Please select [2] to add records.    *\n");
            console.display("******************************************\n");
            return 0;
        }
    }

    public void findHighestQuizRecord(StudentQuizGrades studentRecords) {
        ConsoleIOCalculator console = new ConsoleIOCalculator();
        ArrayList<String> studentNames = new ArrayList<>();
        double studentMax = 0;
        double classMax = 0;

        if (studentRecords.getStudentRecords().size() > 0) {
            Set<String> studentNameList = studentRecords.getStudentRecords().keySet();

            for (String name : studentNameList) {
                for (double score : studentRecords.getStudentRecords().get(name)) {
                    if (studentMax < score) {
                        studentMax = score;
                    }
                }
                if (classMax < studentMax) {
                    classMax = studentMax;
                    studentNames = new ArrayList<>();
                    studentNames.add(name);
                } else if (classMax == studentMax) {
                    studentNames.add(name);

                }
                studentMax = 0;
            }

            for (String name : studentNames) {
                if (name.equals(studentNames.get(studentNames.size() - 1))) {
                    break;
                } else {
                    console.display(name + ", ");
                }
            }
            console.display(studentNames.get(studentNames.size() - 1) + " has the highest quiz score " + classMax + " in the class\n");
        } else {
            console.display("\n******************************************\n");
            console.display("*      No records in the database!       *\n");
            console.display("*   Please select [2] to add records.    *\n");
            console.display("******************************************\n");
        }
    }

    public void findLowestQuizRecord(StudentQuizGrades studentRecords) {
        ConsoleIOCalculator console = new ConsoleIOCalculator();
        ArrayList<String> studentNames = new ArrayList<>();
        double studentMin = 1000;
        double classMin = 1000;

        if (studentRecords.getStudentRecords().size() > 0) {
            Set<String> studentNameList = studentRecords.getStudentRecords().keySet();

            for (String name : studentNameList) {
                for (double score : studentRecords.getStudentRecords().get(name)) {
                    if (studentMin > score) {
                        studentMin = score;
                    }
                }
                if (classMin > studentMin) {
                    classMin = studentMin;
                    studentNames = new ArrayList<>();
                    studentNames.add(name);
                } else if (classMin == studentMin) {
                    studentNames.add(name);
                }
                studentMin = 1000;
            }

            for (String name : studentNames) {
                if (name.equals(studentNames.get(studentNames.size() - 1))) {
                    break;
                } else {
                    console.display(name + ", ");
                }
            }
            console.display(studentNames.get(studentNames.size() - 1) + " has the lowest quiz score " + classMin + " in the class\n");
        } else {
            console.display("\n******************************************\n");
            console.display("*      No records in the database!       *\n");
            console.display("*   Please select [2] to add records.    *\n");
            console.display("******************************************\n");
        }
    }

    // -------------------------------------------------------------------------- Getter & Setter
    public HashMap<String, ArrayList<Double>> getStudentRecords() {
        return studentRecords;
    }

    public void setStudentRecords(HashMap<String, ArrayList<Double>> studentRecords) {
        this.studentRecords = studentRecords;
    }

    // -------------------------------------------------------------------------- Additional Method for better presentation
    // Verify if student record is found in the database
    public boolean findStudentRecord(StudentQuizGrades studentRecords, String searchName) {
        Set<String> studentNameList = studentRecords.getStudentRecords().keySet();

        for (String name : studentNameList) {
            if (name.equals(searchName)) {
                return true;
            }
        }
        return false;
    }

    // Show operation menu
    public void menu() {
        ConsoleIOCalculator console = new ConsoleIOCalculator();

        console.display("\n******************************************\n");
        console.display("*********** Quiz Grades System ***********\n");
        console.display("******************************************\n");
        console.display("**  1. View all students                **\n");
        console.display("**  2. Add a student's record           **\n");
        console.display("**  3. Remove a student's record        **\n");
        console.display("**  4. View a student's all quizs       **\n");
        console.display("**  5. View a student's average score   **\n");
        console.display("**  6. View class's average score       **\n");
        console.display("**  7. View highest score record        **\n");
        console.display("**  8. View lowest score record         **\n");
        console.display("**  9. Quit the Quiz Grades System      **\n");
        console.display("**  0. Display Operation Menu           **\n");
        console.display("******************************************\n");
    }

    // Used for formate average score to 2 decimal poitn
    public String toTwoDecimal(double num) {
        DecimalFormat df = new DecimalFormat("#.##");
        Double d = new Double(num);
        return df.format(d);
    }

//    public static String carriage(int backspaceCount) {
//        ConsoleIOCalculator console = new ConsoleIOCalculator();
//        String carriageString = "";
//
//        for (int i = 0; i < backspaceCount; i++) {
//            carriageString += "\b";
//        }
//        return carriageString;
//    }
}
