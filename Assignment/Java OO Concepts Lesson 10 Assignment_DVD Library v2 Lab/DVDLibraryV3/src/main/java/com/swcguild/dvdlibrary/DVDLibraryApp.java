/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary;

import com.swcguild.dvdlibrary.operation.DVDLibraryController;

/**
 *
 * @author Kratos
 */
public class DVDLibraryApp {

    public static void main(String[] args) {
        DVDLibraryController controller = new DVDLibraryController();
        controller.run();
    }
}
