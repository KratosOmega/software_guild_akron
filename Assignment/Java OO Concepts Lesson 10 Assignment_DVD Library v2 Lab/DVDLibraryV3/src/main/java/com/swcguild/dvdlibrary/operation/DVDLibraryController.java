/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.operation;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.ui.DVDLibraryUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
public class DVDLibraryController {

    private ApplicationContext context;
    private DvdLibraryDao dao;
    private DVDLibraryUI ui;

    public DVDLibraryController() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = (DvdLibraryDao) context.getBean("dvdLibraryDao");
        ui = (DVDLibraryUI) context.getBean("dvdLibraryUi");
    }

    public void run() {
        boolean quit = false;
        boolean repeatExecution = false;
        String operation = "";

        ui.menu();

        while (!quit) {
            if (!repeatExecution) {
                operation = ui.promptOperation();
            }

            switch (operation) {
                case "1":
                    // Add
                    addDVD();
                    break;
                case "2":
                    // Remove
                    removeDVD();
                    break;
                case "3":
                    // Edit
                    listAllDVD();
                    break;
                case "4":
                    // List
                    getDVDsById();
                    break;
                case "5":
                    // Search by title
                    getDVDsyTitle();
                    break;
                case "6":
                    getDVDsByRating();
                    break;
                case "7":
                    getDVDsByStudio();
                    break;
                case "8":
                    ui.menu();
                    break;
                case "-1":
                    quit = true;
                    ui.quit();
                    break;
                default:
                    ui.message_InvalidIput();
            }
        }
    }

    public void addDVD() {
        dao.add(ui.promptAdd());
    }

    public void removeDVD() {
        int id = ui.promptGetId();
        dao.remove(id);
    }

    public void listAllDVD() {
        ui.listMultiple(dao.listAll());
    }

    public void getDVDsById() {
        int id = ui.promptSearchId();
        ui.listOne(dao.getById(id));

    }

    public void getDVDsyTitle() {
        String title = ui.promptSearchTitle();
        ui.listMultiple(dao.getByTitle(title));
    }

    public void getDVDsByRating() {
        String rating = ui.promptSearchRating();
        ui.listMultiple(dao.getByRating(rating));
    }

    public void getDVDsByStudio() {
        String studio = ui.promptSearchStudio();
        ui.listMultiple(dao.getByStudio(studio));
    }
}
