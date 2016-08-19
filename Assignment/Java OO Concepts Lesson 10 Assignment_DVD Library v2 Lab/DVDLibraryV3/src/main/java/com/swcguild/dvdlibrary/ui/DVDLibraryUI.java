/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.ui;

import com.swcguild.dvdlibrary.dto.Dvd;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
public class DVDLibraryUI {

    private ConsoleIO io;
    private GUIUtilities guiUtilities;
    private int id;

    public DVDLibraryUI() {
        this.io = new ConsoleIO();
        this.guiUtilities = new GUIUtilities();
        this.id = 0;
    }

    // ********************************************************************** Initialization
    // ********************************************************************** Dispaly Menu
    public void menu() {
        io.display(guiUtilities.os_Quick_Menu_Builder("DVD Library System", "/",
                "1. Add DVD record to Libaray/"
                + "2. Remove DVD record from Library/"
                + "3. List DVD records in the Library/"
                + "4. Search DVDs By ID/"
                + "5. Search DVDs By Title/"
                + "6. Search DVDs By Rating/"
                + "7. Search DVDs By Studio/"
                + "8. Display Operation Menu") + "\n");
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Quit>") + "\n");

    }

    public String promptOperation() {
        io.display("\n" + guiUtilities.os_Component_Builder("=", 50) + "\n");
        return io.promptForString("Please choose operation: ");
    }

    public void message_InvalidIput() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Invalid Input!!!/Please enter again..."));
    }

    public Dvd promptAdd() {
        Dvd newRecord = new Dvd();
        newRecord.setId(id);
        newRecord.setTitle(io.promptForString("> DVD Title       : "));
        newRecord.setReleaseDate(io.promptForInt("> Release Date    : "));
        newRecord.setMpaaRating(io.promptForString("> MPAA Rating     : "));
        newRecord.setDirector(io.promptForString("> Director's Name : "));
        newRecord.setStudio(io.promptForString("> Studio          : "));
        newRecord.setNote(io.promptForString("> User Note       : "));
        id++;
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
            io.display("> DVD id              : " + record.getId() + "\n");
            io.display("> DVD Title           : " + record.getTitle() + "\n");
            io.display("> Release Date        : " + record.getReleaseDate() + "\n");
            io.display("> MPAA Rating         : " + record.getMpaaRating() + "\n");
            io.display("> Director's Name     : " + record.getDirector() + "\n");
            io.display("> Studio              : " + record.getStudio() + "\n");
            io.display("> User Note           : " + record.getNote() + "\n");
        }
    }

    public void listOne(Dvd dvd) {
        io.display(guiUtilities.os_Quick_Header_Builder("List Records") + "\n");
        io.display("> DVD id              : " + dvd.getId() + "\n");
        io.display("> DVD Title           : " + dvd.getTitle() + "\n");
        io.display("> Release Date        : " + dvd.getReleaseDate() + "\n");
        io.display("> MPAA Rating         : " + dvd.getMpaaRating() + "\n");
        io.display("> Director's Name     : " + dvd.getDirector() + "\n");
        io.display("> Studio              : " + dvd.getStudio() + "\n");
        io.display("> User Note           : " + dvd.getNote() + "\n");
    }

    public int promptSearchId() {
        return io.promptForInt("Please enter ID: ");
    }

    public String promptSearchTitle() {
        return io.promptForString("Please enter title: ");
    }

    public String promptSearchRating() {
        return io.promptForString("Please enter rating: ");
    }

    public String promptSearchStudio() {
        return io.promptForString("Please enter studio name: ");
    }
    
    public void quit(){
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Thank you!"));
    }
}
