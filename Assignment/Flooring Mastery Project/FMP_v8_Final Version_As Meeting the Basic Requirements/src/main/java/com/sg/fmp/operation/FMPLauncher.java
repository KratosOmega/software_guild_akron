/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fmp.operation;

import com.sg.fmp.ui.FMPUi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
public class FMPLauncher {

    private final ApplicationContext context;
    private final FMPUi ui;
    private FMPController fMPController;

    public FMPLauncher() {
        this.context = new ClassPathXmlApplicationContext("modeContext.xml");
        this.ui = new FMPUi();
    }

    public void execute() {
        boolean quit = false;
        boolean runMode = false;
        String operation = "";

        ui.nextPage();
        ui.modeMenu();

        while (!quit) {
            operation = ui.promptForOperation();

            ui.nextPage();
            switch (operation) {
                case "1":
                    // List
                    fMPController = (FMPTestController) context.getBean("test");
                    quit = true;
                    runMode = true;
                    break;
                case "2":
                    // Add
                    fMPController = (FMPProductionController) context.getBean("production");
                    quit = true;
                    runMode = true;
                    break;
                case "-1":
                    quit = true;
                    break;
                default:
                    ui.message_InvalidIput();
            }
        }

        if (quit && runMode) {
            fMPController.execute();
        }
    }
}
