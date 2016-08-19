/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.operation;

import com.swcguild.dvdlibrary.dao.DvdLibraryApi;
import com.swcguild.dvdlibrary.ui.DVDLibraryUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
public class DvdLibraryController {

    private final ApplicationContext context;
    private final DvdLibraryApi dao;
    private final DVDLibraryUI ui;

    public DvdLibraryController() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = (DvdLibraryApi) context.getBean("dvdLibraryApiImplementation");
        ui = (DVDLibraryUI) context.getBean("dvdLibraryUi");
    }

    public void run() {
        boolean quit = false;
        boolean repeatExecution = false;
        String operation = "";

        ui.mainMenu();

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
                    applyFilter();
                    break;
                case "9":
                    ui.mainMenu();
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
        ui.message_ActionCompleted();
    }

    public void removeDVD() {
        int id = ui.promptGetId();
        dao.remove(id);
        ui.message_ActionCompleted();
    }

    public void listAllDVD() {
        ui.listMultiple(dao.listAll());
    }

    public void getDVDsById() {
        int id = ui.promptId();
        if (dao.getById(id) == null) {
            ui.message_DataNotFounded();
        } else {
            ui.listOne(dao.getById(id));
        }
    }

    public void getDVDsyTitle() {
        String title = ui.promptTitle();
        if (dao.getByTitle(title).isEmpty()) {
            ui.message_DataNotFounded();
        } else {
            ui.listMultiple(dao.getByTitle(title));
        }
    }

    public void getDVDsByRating() {
        String rating = ui.promptMpaaRating();
        if (dao.getByRating(rating).isEmpty()) {
            ui.message_DataNotFounded();
        } else {
            ui.listMultiple(dao.getByRating(rating));
        }
    }

    public void getDVDsByStudio() {
        String studio = ui.promptStudioName();
        if (dao.getByStudio(studio).isEmpty()) {
            ui.message_DataNotFounded();
        } else {
            ui.listMultiple(dao.getByStudio(studio));
        }
    }

    // *************************************** Filter Section (DVD Library V2 Feature)
    public void applyFilter() {
        boolean quit = false;
        boolean repeatExecution = false;
        String operation = "";

        ui.subMenu();

        while (!quit) {
            if (!repeatExecution) {
                operation = ui.promptOperation();
            }

            switch (operation) {
                case "1":
                    // Add
                    filterReleaseYears();
                    break;
                case "2":
                    // Remove
                    filterMpaaRating();
                    break;
                case "3":
                    // Edit
                    filterDirector();
                    break;
                case "4":
                    // List
                    filterStudio();
                    break;
                case "5":
                    // Search by title
                    filterAvgAge();
                    break;
                case "6":
                    filterNewest();
                    break;
                case "7":
                    filterOldest();
                    break;
                case "8":
                    filterAvgNotes();
                    break;
                case "9":
                    ui.subMenu();
                    break;
                case "-1":
                    quit = true;
                    ui.backToMain();
                    break;
                default:
                    ui.message_InvalidIput();
            }
        }
    }

    public void filterReleaseYears() {
        int nYears = ui.promptNYears();
        ui.listMultiple(dao.filterNYears(nYears));
    }

    public void filterMpaaRating() {
        String mpaaRating = ui.promptMpaaRating();
        ui.listMultiple(dao.filterRating(mpaaRating));
    }

    public void filterDirector() {
        String directorName = ui.promptDirectorName();
        ui.listMultiple(dao.filterDirector(directorName));
    }

    public void filterStudio() {
        String studioName = ui.promptStudioName();
        ui.listMultiple(dao.fitlerStudio(studioName));
    }

    public void filterAvgAge() {
        ui.avg(dao.fitlerAvgAge());
    }

    public void filterNewest() {
        ui.listOne(dao.fitlerNewestMovie());
    }

    public void filterOldest() {
        ui.listOne(dao.fitlerOldestMovie());
    }

    public void filterAvgNotes() {
        ui.avg(dao.calculateAvgNotes());
    }
}
