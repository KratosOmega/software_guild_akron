/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exceptionaldemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author softwareguild
 */
public class FunWithExceptions {
    // Since this file name isn't changeable, let's make it a final variable
    private static final String OUTPUT_FILE = "OutFile.txt";

    public static void main(String[] args) {
        try {
            writeSampleFile();
        } catch (IOException e){
            System.out.println("Problem writing to file");
        } finally {
            readSampleFile();
        }
    }

    public static void writeSampleFile() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_FILE));
        out.println("This is a test");
        out.println("More file samples in the next lesson");
        out.flush();
        out.close();
    }

    public static void readSampleFile() {
        System.out.println("Try reading from a file");
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(OUTPUT_FILE)))){
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Problem reading from " + OUTPUT_FILE);
        }
        System.out.println("Done trying to read from a file");

    }

}
