/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.ui;

import com.swcguild.dvdlibrary.dao.DvdLibraryImplementation;
import com.swcguild.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author Kratos
 */
public class DVDLibraryUI {

    private final ConsoleIO io;
    private final GUIUtilities guiUtilities;

    public DVDLibraryUI() {
        this.io = new ConsoleIO();
        this.guiUtilities = new GUIUtilities();
    }

    // ********************************************************************** Initialization
    // ********************************************************************** Dispaly Menu
    public void mainMenu() {
        io.display(guiUtilities.os_Quick_Menu_Builder("DVD Library System", "/",
                "1. Add DVD record to Libaray/"
                + "2. Remove DVD record from Library/"
                + "3. List DVD records in the Library/"
                + "4. Search DVDs By ID/"
                + "5. Search DVDs By Title/"
                + "6. Search DVDs By Rating/"
                + "7. Search DVDs By Studio/"
                + "8. Apply filter to the database/"
                + "9. Display Operation Menu") + "\n");
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Quit>") + "\n");
    }

    public void subMenu() {
        io.display(guiUtilities.os_Quick_Menu_Builder("DVD Filter", "/",
                "1. Filter all movies release in the last N years/"
                + "2. Filter all the movies with a given MPAA rating/"
                + "3. Find all the movies by a given director (sorted by MPAA rating)/"
                + "4. Find all the movies release by a particular studio/"
                + "5. Find the average age of the movies in the collection/"
                + "6. Find the newest movie in your collection/"
                + "7. Find the oldest movie in your collection/"
                + "8. Find the average number of notes in your collection/"
                + "9. Display Operation Menu") + "\n");
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Quit>") + "\n");
    }

    public String promptOperation() {
        io.display("\n" + guiUtilities.os_Component_Builder("=", 100) + "\n");
        return io.promptForString("Please choose operation: ");
    }

    public void message_InvalidIput() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Invalid Input!!!/Please enter again..."));
    }

    public Dvd promptAdd() {
        Dvd newRecord = new Dvd();
        newRecord.setId(DvdLibraryImplementation.id);
        newRecord.setTitle(io.promptForString("> DVD Title       : "));
        newRecord.setReleaseDate(io.promptForInt("> Release Date    : "));
        newRecord.setMpaaRating(io.promptForString("> MPAA Rating     : "));
        newRecord.setDirector(io.promptForString("> Director's Name : "));
        newRecord.setStudio(io.promptForString("> Studio          : "));
        newRecord.setNote(io.promptForString("> User Note       : "));
        DvdLibraryImplementation.id++;
        return newRecord;
    }

    public int promptGetId() {
        return io.promptForInt("Please enter the DVD id: ");
    }

    public void listMultiple(List<Dvd> dvds) {
        int index = 0;

        io.display(guiUtilities.os_Quick_Header_Builder("List Records"));

        for (Dvd record : dvds) {
            index++;

            io.display("\n" + guiUtilities.os_Quick_Header_Builder("# " + index + "") + "\n");
            io.display("                             > DVD id                               : " + record.getId() + "\n");
            io.display("                             > DVD Title                            : " + record.getTitle() + "\n");
            io.display("                             > Release Date                         : " + record.getReleaseDate() + "\n");
            io.display("                             > MPAA Rating                          : " + record.getMpaaRating() + "\n");
            io.display("                             > Director's Name                      : " + record.getDirector() + "\n");
            io.display("                             > Studio                               : " + record.getStudio() + "\n");
            if (record.getNote() == null) {
                io.display("                             > User Note                            : \n");
            } else {
                io.display("                             > User Note                            : " + record.getNote() + "\n");
            }
        }
    }

    public void listOne(Dvd dvd) {
        io.display(guiUtilities.os_Quick_Header_Builder("List Records") + "\n");
        io.display("                             > DVD id                               : " + dvd.getId() + "\n");
        io.display("                             > DVD Title                            : " + dvd.getTitle() + "\n");
        io.display("                             > Release Date                         : " + dvd.getReleaseDate() + "\n");
        io.display("                             > MPAA Rating                          : " + dvd.getMpaaRating() + "\n");
        io.display("                             > Director's Name                      : " + dvd.getDirector() + "\n");
        io.display("                             > Studio                               : " + dvd.getStudio() + "\n");
        if (dvd.getNote() == null) {
            io.display("                             > User Note                            : \n");
        } else {
            io.display("                             > User Note                            : " + dvd.getNote() + "\n");
        }
    }

    public int promptId() {
        return io.promptForInt("Please enter ID: ");
    }

    public String promptTitle() {
        return io.promptForString("Please enter title: ");
    }

    public int promptReleaseDate() {
        return io.promptForInt("Please enter release date: ");
    }

    public String promptMpaaRating() {
        return io.promptForString("Please enter MPAA Rating: ");
    }

    public String promptDirectorName() {
        return io.promptForString("Please enter director's name: ");
    }
    
    public String promptStudioName(){
        return io.promptForString("Please enter studio's name: ");
    }

    public int promptNYears() {
        return io.promptForInt("Please enter years: ");
    }

    public void avg(double count) {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "The average is " + count));
    }

    public void message_ActionCompleted() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Action Performed!"));
    }
    
    public void message_DataNotFounded(){
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Data not founded!"));
    }

    public void quit() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Thank you!"));
    }

    public void backToMain() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "You are back to main menu"));
    }
}
