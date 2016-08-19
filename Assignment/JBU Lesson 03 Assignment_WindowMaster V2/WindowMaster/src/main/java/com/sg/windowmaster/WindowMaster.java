/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.windowmaster;

/**
 *
 * @author Kratos
 */
import java.util.Scanner;

public class WindowMaster {

    public static void main(String[] args) {
        float height;
        float width;

        String stringHeight;
        String stringWidth;

        float areaOfWindow;
        float cost;
        float perimeterOfWindow;
        float priceOfGlass;
        float priceOfTrim;

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the price of glass: ");
        priceOfGlass = Float.parseFloat(sc.nextLine());
        System.out.println("Please enter the price of trim: ");
        priceOfTrim = Float.parseFloat(sc.nextLine());
        
        System.out.println("Please enter window height: ");
        stringHeight = sc.nextLine();
        System.out.println("Please enter window width:");
        stringWidth = sc.nextLine();

        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);

        areaOfWindow = height * width;
        perimeterOfWindow = 2 * (height + width);

        //Remember to add "f" for float valuez
        cost = (priceOfGlass * areaOfWindow) + (priceOfTrim * perimeterOfWindow);
        System.out.println("Glass price = " + priceOfGlass);
        System.out.println("Trim price = " + priceOfTrim);
        System.out.println("Window height = " + stringHeight);
        System.out.println("Window width = " + stringWidth);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total cost = " + cost);
    }
}
