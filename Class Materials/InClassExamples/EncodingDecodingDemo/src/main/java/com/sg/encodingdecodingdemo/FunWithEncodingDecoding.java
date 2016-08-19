/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.encodingdecodingdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author softwareguild
 */
public class FunWithEncodingDecoding {

    // we do this as a final string since it is a constant value that won't change
    private static final String FILE_DELIMITER = "::";
    private static final String STUDENTS_FILE_NAME = "Students.txt";
    
    public static void main(String[] args) throws IOException {
        
        Student[] sampleStudents = new Student[3];
        
        // You can initialize the fields individually...
        Student student1 = new Student("0001");
        student1.setFirstName("John");
        student1.setLastName("Doe");
        student1.setCohort("Java - May 2016");
        
        // Or you can use an overloaded constructor
        Student student2 =  new Student("0002", "Sally", "Smith", "Java - May 2016");
        Student student3 = new Student("0003", "Sam", "Jones", ".NET - May 2016");

        sampleStudents[0] = student1;
        sampleStudents[1] = student2;
        sampleStudents[2] = student3;

        writeStudentData(sampleStudents);
        readStudentData();
    }

    public static void writeStudentData(Student[] students) throws IOException {
        // open file for writing
        PrintWriter out = new PrintWriter(new FileWriter(STUDENTS_FILE_NAME));

        // go through a collection of students
        for (Student student : students) {
            // for each Student:
            // - create string with the id, first name, last name, and cohort separated by ::
            String studentInfo = student.getStudentId() + FILE_DELIMITER + student.getFirstName() + FILE_DELIMITER
                    + student.getLastName() + FILE_DELIMITER + student.getCohort();
            // - output to the file
            out.println(studentInfo);
        }
        // close the file
        out.flush();
        out.close();
    }

    public static void readStudentData() throws IOException {
        // open the file for reading
        // create a collection for our single objects
        ArrayList<Student> studentList = new ArrayList<Student>();
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(STUDENTS_FILE_NAME)))) {
            while (sc.hasNextLine()) {
                // loop through our file line by line
                // for each line :
                String studentStringEncoded = sc.nextLine();
                // Our ID is first
                String[] studentProperties = studentStringEncoded.split(FILE_DELIMITER);
                // - Create a Student object
                // - Map the fields from the file to the properties of the object
                Student newStudent = new Student(studentProperties[0]);
                newStudent.setFirstName(studentProperties[1]);
                newStudent.setLastName(studentProperties[2]);
                newStudent.setCohort(studentProperties[3]);
                // - Add our student to the collection of students
                studentList.add(newStudent);

            }
        } catch (IOException e) {
            System.out.println("Problem reading from " + STUDENTS_FILE_NAME);
        }

        // loop through the collection and print them out
        for (Student s : studentList) {
            System.out.println(s.toString());
        }
    }
}
