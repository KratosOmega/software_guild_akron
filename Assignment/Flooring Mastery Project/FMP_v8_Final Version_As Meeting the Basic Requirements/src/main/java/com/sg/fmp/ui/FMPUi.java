/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fmp.ui;

import com.sg.fmp.dto.Order;
import com.sg.fmp.dto.Product;
import com.sg.fmp.dto.Tax;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Kratos
 */
public class FMPUi {

    private ConsoleIO io;
    private GUIUtilities gui;

    public FMPUi() {
        this.io = new ConsoleIO();
        this.gui = new GUIUtilities();
    }

    // *************************************************************************************************************** General UI
    public void prodMenu() {
        io.display(gui.os_Quick_Menu_Builder("Flooring Mastery Project (Production Mode)", "/",
                "1. List all orders/"
                + "2. Add new order/"
                + "3. Edit an order/"
                + "4. Remove an order/"
                + "5. Save current work/"
                + "!. Settings/"
                + "0. Display menu") + "\n");
        io.display(gui.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Quit>") + "\n");
    }

    public void testMenu() {
        io.display(gui.os_Quick_Menu_Builder("Flooring Mastery Project (Testing Mode)", "/",
                "1. List all orders/"
                + "2. Add new order/"
                + "3. Edit an order/"
                + "4. Remove an order/"
                + "!. Settings/"
                + "0. Display menu") + "\n");
        io.display(gui.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Quit>") + "\n");
    }

    public void modeMenu() {
        io.display(gui.os_Quick_Menu_Builder("Mode Menu", "/", "1. Test Mode/2. Production Mode") + "\n");
        io.display(gui.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Quit>") + "\n");
    }

    public void settingMenu() {
        io.display(gui.os_Quick_Menu_Builder("Settings", "/",
                "1. Switch Modes/"
                + "2. Snapshot/"
                + "0. Display menu") + "\n");
        io.display(gui.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Return to Previous Page>") + "\n");
    }

    public void snapshotMenu() {
        io.display(gui.os_Quick_Menu_Builder("Snapshot", "/",
                "1. Browse the snapshots/"
                + "2. Create a snapshot/"
                + "3. Restore on a snapshot/"
                + "0. Display menu") + "\n");
        io.display(gui.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Return to Previous Page>") + "\n");
    }

    public void displayRecords(List<Order> orders) {

        if (orders != null) {

            final List<Order> filteredOrders = orders
                    .stream()
                    .filter(unfilteredOrders -> unfilteredOrders.isOrderStatus())
                    .collect(Collectors.toList());

            if (filteredOrders.isEmpty()) {
                message_RecordNotFound();
            } else {
                io.display(gui.os_Quick_Notification_Builder("/", "List Orders") + "\n");
                IntStream
                        .range(0, filteredOrders.size())
                        .forEach(index -> {
                            final Order singleOrder;
                            singleOrder = filteredOrders.get(index);
                            io.display(gui.os_Quick_Header_Builder("# " + (index + 1)) + "\n");
                            io.leftAdj(20, "", "", "", "", "Order Number: ");
                            io.leftAdj(20, "", "", "", "", singleOrder.getOrderNumber());
                            io.display("         ||         ");
//                        io.leftAdj(20, "", "", "", "", "Order Status: ");
//                        io.leftAdj(20, "", "", "", "", order.showOrderStatus());
                            io.leftAdj(20, "", "", "", "", "Customer Name: ");
                            io.leftAdj(20, "", "", "", "", singleOrder.getCustomerName());
                            io.newLine();

                            io.leftAdj(20, "", "", "", "", "State: ");
                            io.leftAdj(20, "", "", "", "", singleOrder.getState());
                            io.display("         ||         ");
                            io.leftAdj(20, "", "", "", "", "Tax Rate: ");
                            io.leftAdj(20, "", "", "", " %", singleOrder.getTaxRate());
                            io.newLine();

                            io.leftAdj(20, "", "", "", "", "Product Type: ");
                            io.leftAdj(20, "", "", "", "", singleOrder.getProductType());
                            io.display("         ||         ");
                            io.leftAdj(20, "", "", "", "", "Area: ");
                            io.leftAdj_2Dec(20, "", "", "", " ft" + String.valueOf((char) 178), singleOrder.getArea());
                            io.newLine();

                            io.leftAdj(20, "", "", "", "", "Material Price: ");
                            io.leftAdj_2Dec(20, "", "", "$ ", " / ft" + String.valueOf((char) 178), singleOrder.getCostPerSqrtFoot());
                            io.display("         ||         ");
                            io.leftAdj(20, "", "", "", "", "Labor Price: ");
                            io.leftAdj_2Dec(20, "", "", "$ ", " / ft" + String.valueOf((char) 178), singleOrder.getLaborCostPerSqrtFoot());
                            io.newLine();

                            io.leftAdj(20, "", "", "", "", "Material Cost: ");
                            io.leftAdj_2Dec(20, "", "", "$ ", "", singleOrder.getMaterialCost());
                            io.display("         ||         ");
                            io.leftAdj(20, "", "", "", "", "Labor Cost: ");
                            io.leftAdj_2Dec(20, "", "", "$ ", "", singleOrder.getLaborCost());
                            io.newLine();

                            io.leftAdj(20, "", "", "", "", "Tax: ");
                            io.leftAdj_2Dec(20, "", "", "$ ", "", singleOrder.getTax());
                            io.display("         ||         ");
                            io.leftAdj(20, "", "", "", "", "Total Cost: ");
                            io.leftAdj_2Dec(20, "", "", "$ ", "", singleOrder.getTotal());
                            io.newLine();
                            io.newLine();
                        });
            }
        } else {
            message_RecordNotFound();
        }
    }

    public void displayRecordSummary(Order order) {
        io.leftAdj(20, "", "", "", "", "Order Number: ");
        io.leftAdj(20, "", "", "", "", order.getOrderNumber());
//                        io.leftAdj(25, "", "", "", "", "Order Status: ");
//                        io.leftAdj(25, "", "", "", "", order.showOrderStatus());
        io.display("         ||         ");
        io.leftAdj(20, "", "", "", "", "Customer Name: ");
        io.leftAdj(20, "", "", "", "", order.getCustomerName());
        io.newLine();

        io.leftAdj(20, "", "", "", "", "State: ");
        io.leftAdj(20, "", "", "", "", order.getState());
        io.display("         ||         ");
        io.leftAdj(20, "", "", "", "", "Tax Rate: ");
        io.leftAdj(20, "", "", "", " %", order.getTaxRate());
        io.newLine();

        io.leftAdj(20, "", "", "", "", "Product Type: ");
        io.leftAdj(20, "", "", "", "", order.getProductType());
        io.display("         ||         ");
        io.leftAdj(20, "", "", "", "", "Area: ");
        io.leftAdj_2Dec(20, "", "", "", " ft" + String.valueOf((char) 178), order.getArea());
        io.newLine();

        io.leftAdj(20, "", "", "", "", "Material Price: ");
        io.leftAdj_2Dec(20, "", "", "$ ", " /ft" + String.valueOf((char) 178), order.getCostPerSqrtFoot());
        io.display("         ||         ");
        io.leftAdj(20, "", "", "", "", "Labor Price: ");
        io.leftAdj_2Dec(20, "", "", "$ ", " /ft" + String.valueOf((char) 178), order.getLaborCostPerSqrtFoot());
        io.newLine();

        io.leftAdj(20, "", "", "", "", "Material Cost: ");
        io.leftAdj_2Dec(20, "", "", "$ ", "", order.getMaterialCost());
        io.display("         ||         ");
        io.leftAdj(20, "", "", "", "", "Labor Cost: ");
        io.leftAdj_2Dec(20, "", "", "$ ", "", order.getLaborCost());
        io.newLine();

        io.leftAdj(20, "", "", "", "", "Tax: ");
        io.leftAdj_2Dec(20, "", "", "$ ", "", order.getTax());
        io.display("         ||         ");
        io.leftAdj(20, "", "", "", "", "Total Cost: ");
        io.leftAdj_2Dec(20, "", "", "$ ", "", order.getTotal());
        io.newLine();
    }

    public void displayYesOrNo() {
        io.display(gui.os_Quick_Notification_Builder("#", "Please confirm this execution#\"Y\"/\"N\"") + "\n");
    }

    public void displaySnapshots(List<String> snapshots) {
        // Dynamically display menu
        String snapshotsString = "";
        for (int i = 0; i < snapshots.size(); i++) {
            snapshotsString += (i + 1) + ". " + snapshots.get(i) + "/";
        }

        io.display(gui.os_Quick_Menu_Builder("Snapshot List", "/", snapshotsString) + "\n");
    }

    public void displaySnapshotDetails(List<String> snapshotInfo) {
        io.display(gui.os_Quick_Menu_Builder("Snapshot of " + snapshotInfo.get(0),
                "/", "# of Add    :              " + snapshotInfo.get(1) + "/"
                + "# of Edit   :              " + snapshotInfo.get(2) + "/"
                + "# of Remove :              " + snapshotInfo.get(3) + "/") + "\n");
    }

    public String getKeySet(Set<String> keySet) {
        String keySetString = "";
        keySetString = keySet.stream().map((key) -> key.toString() + "/").reduce(keySetString, String::concat);
        return keySetString;
    }

    public void nextPage() {
        io.refreshScreen();
    }

    // *************************************************************************************************************** Prompt UI
    public String promptForOperation() {
        return io.promptForString("Choose your operation: ");
    }

    public String promptForDate() {
        return io.promptForString("Please enter the date: ");
    }

    public String promptForOrderNumber() {
        return "" + io.promptForIntWithinRange("Please enter the order number: ", 1, 9999999);
    }

    public Order promptForAddNewOrder(int orderNumber, Map<String, Product> products, Map<String, Tax> taxes) {
        String state = "";
        String productType = "";

        // Get Customer Name
        header_Add();
        String customerName = io.promptForString("> Please enter customer name: ");
        nextPage();

        // Get State
        while (true) {
            header_Add();
            io.display(gui.os_Quick_Notification_Builder("/", "States Choices") + "\n");
            io.display(gui.os_Quick_Notification_Builder("/", getKeySet(taxes.keySet())) + "\n");
            String tempState = io.promptForString("> Please enter state: ");

            List<String> stateName = taxes.keySet().stream().filter(statesInDatabase -> statesInDatabase.equalsIgnoreCase(tempState)).collect(Collectors.toList());

            if (stateName.isEmpty()) {
                nextPage();
                io.display(gui.os_Quick_Notification_Builder("/", "[ " + tempState + " ]" + " does not exist in database!/Please enter again") + "\n\n\n\n\n");
            } else {
                state = stateName.get(0);
                break;
            }
        }
        nextPage();

        // Get Product
        while (true) {
            header_Add();
            io.display(gui.os_Quick_Notification_Builder("/", "Product Choices") + "\n");
            io.display(gui.os_Quick_Notification_Builder("/", getKeySet(products.keySet())) + "\n");
            String tempProductType = io.promptForString("> Please enter product type: ");

            List<String> productName = products.keySet().stream().filter(productTypeInDatabase -> productTypeInDatabase.equalsIgnoreCase(tempProductType)).collect(Collectors.toList());

            if (productName.isEmpty()) {
                nextPage();
                io.display(gui.os_Quick_Notification_Builder("/", "[ " + tempProductType + " ]" + " does not exist in database!/Please enter again") + "\n\n\n\n\n");
            } else {
                productType = productName.get(0);
                break;
            }
        }
        nextPage();

        // Get area
        header_Add();
        double area = io.promptForDoubleWithinRange("> Please enter area: ", 0.0, 999999999999999999999999.0);

        // Distribute other property base on the 4 inputs
        double taxRate = taxes.get(state).getTaxRate();
        double costPerSqrtFoot = products.get(productType).getCostPerSqrtFoot();
        double laborCostPerSqrtFoot = products.get(productType).getLaborCostPerSqrtFoot();
        double materialCost = area * costPerSqrtFoot;
        double laborCost = area * laborCostPerSqrtFoot;
        double tax = (materialCost + laborCost) * taxRate / 100;
        double total = (materialCost + laborCost) * (1 + taxRate);

        return new Order(
                orderNumber,
                true,
                customerName,
                state,
                taxRate,
                productType,
                area,
                costPerSqrtFoot,
                laborCostPerSqrtFoot,
                materialCost,
                laborCost,
                tax,
                total
        );
    }

    public Order promptForEditOrder(Order givenOrder, Map<String, Product> products, Map<String, Tax> taxes) {
        Order order = new Order(
                givenOrder.getOrderNumber(),
                givenOrder.isOrderStatus(),
                givenOrder.getCustomerName(),
                givenOrder.getState(),
                givenOrder.getTaxRate(),
                givenOrder.getProductType(), 
                givenOrder.getArea(), 
                givenOrder.getCostPerSqrtFoot(), 
                givenOrder.getLaborCostPerSqrtFoot(), 
                givenOrder.getMaterialCost(), 
                givenOrder.getLaborCost(), 
                givenOrder.getTax(), 
                givenOrder.getTotal());
        String inputString = "";
        double inputDouble = -1.0;

        io.display(gui.os_Quick_Header_Builder("") + "\n");
        io.leftAdj(50, "Order Number: ", "", "", "", order.getOrderNumber());
        io.leftAdj(50, "Order Status: ", "", "", "", order.showOrderStatus());
        io.newLine();

        io.leftAdj(50, "Customer Name: ", "", "", "", order.getCustomerName());
        io.leftAdj(20, "============ >>> ", "", "", ": ", "Enter new value");
        inputString = io.promptForString("");
        if (!inputString.equals("")) {
            order.setCustomerName(inputString);
            inputString = "";
        }

        while (true) {
            io.display(gui.os_Quick_Notification_Builder("/", "States Choices") + "\n");
            io.display(gui.os_Quick_Notification_Builder("/", getKeySet(taxes.keySet())) + "\n");
            io.leftAdj(50, "State: ", "", "", "", order.getState());
            io.leftAdj(20, "============ >>> ", "", "", ": ", "Enter new value");

            final String tempState = io.promptForString("");

            if (tempState.equals("")) {
                break;
            } else {
                List<String> stateName = taxes.keySet().stream().filter(statesInDatabase -> statesInDatabase.equalsIgnoreCase(tempState)).collect(Collectors.toList());

                if (stateName.isEmpty()) {
                    nextPage();
                    io.display(gui.os_Quick_Notification_Builder("/", "[ " + tempState + " ]" + " does not exist in database!/Please enter again") + "\n\n\n\n\n");
                } else {
                    order.setState(stateName.get(0));
                    break;
                }
            }
        }

        /*
        // Get State
        while (true) {
            header_Add();
            io.display(gui.os_Quick_Notification_Builder("/", "States Choices") + "\n");
            io.display(gui.os_Quick_Notification_Builder("/", getKeySet(taxes.keySet())) + "\n");
            String tempState = io.promptForString("> Please enter state: ");

            List<String> stateName = taxes.keySet().stream().filter(statesInDatabase -> statesInDatabase.equalsIgnoreCase(tempState)).collect(Collectors.toList());

            if (stateName.isEmpty()) {
                nextPage();
                io.display(gui.os_Quick_Notification_Builder("/", "[ " + tempState + " ]" + " does not exist in database!/Please enter again") + "\n\n\n\n\n");
            } else {
                state = stateName.get(0);
                break;
            }
        }
        nextPage();
         */
        while (true) {
            io.display(gui.os_Quick_Notification_Builder("/", "Product Choices") + "\n");
            io.display(gui.os_Quick_Notification_Builder("/", getKeySet(products.keySet())) + "\n");
            io.leftAdj(50, "Product Type: ", "", "", "", order.getProductType());
            io.leftAdj(20, "============ >>> ", "", "", ": ", "Enter new value");

            final String tempProductType = io.promptForString("");

            if (tempProductType.equals("")) {
                break;
            } else {
                List<String> productName = products.keySet().stream().filter(productInDatabase -> productInDatabase.equalsIgnoreCase(tempProductType)).collect(Collectors.toList());

                if (productName.isEmpty()) {
                    nextPage();
                    io.display(gui.os_Quick_Notification_Builder("/", "[ " + tempProductType + " ]" + " does not exist in database!/Please enter again") + "\n\n\n\n\n");
                } else {
                    order.setProductType(productName.get(0));
                    break;
                }
            }
        }

        io.leftAdj(50, "Area: ", "", "", "", order.getArea());
        io.leftAdj(20, "============ >>> ", "", "", ": ", "Enter new value");
        inputDouble = io.promptForDoubleWithinRange_SpecialCase("", 0, 999999999);
        if (inputDouble >= 0) {
            order.setArea(inputDouble);
            inputDouble = -1.0;
        }

        return order;
    }

    public String promptForSnapshot(int snapshotCount) {
        int selection = io.promptForIntWithinRange("Please selection a snapshot: ", 1, snapshotCount);
        return selection + "";
    }

    // *************************************************************************************************************** Message UI
    public void message_InvalidIput() {
        io.display("\n" + gui.os_Quick_Notification_Builder("/", "Invalid Input!") + "\n");
    }

    public void message_RecordNotFound() {
        io.display("\n" + gui.os_Quick_Notification_Builder("/", "No record is founded!") + "\n");
    }

    public void message_EditDone() {
        io.display("\n" + gui.os_Quick_Notification_Builder("/", "Record is edited!") + "\n");
    }

    public void message_RemoveDone() {
        io.display("\n" + gui.os_Quick_Notification_Builder("/", "Record is removed") + "\n");
    }

    public void message_ConfirmAdd() {
        io.display("\n" + gui.os_Quick_Notification_Builder("/", "New Order is added!") + "\n");
    }

    public void message_DiscardAdd() {
        io.display("\n" + gui.os_Quick_Notification_Builder("/", "New Order is discarded!") + "\n");
    }

    public void message_NothingIsDone() {
        io.display("\n" + gui.os_Quick_Notification_Builder("/", "No data is changed!") + "\n");
    }

    public void message_DataSaved() {
        io.display("\n" + gui.os_Quick_Notification_Builder("/", "Data is saved in database!") + "\n");
    }

    public void message_SnapshotApplied() {
        io.display("\n" + gui.os_Quick_Notification_Builder("/", "Snapshot is applied/Order database is updated") + "\n");
    }

    public void message_NextSection() {
        io.display(gui.os_Quick_Notification_Builder(";", "|  |;|  |;_|  |_;\\    /;\\  /;\\/;") + "\n");
    }

    public void message_DateFormat() {
        io.display(gui.os_Quick_Notification_Builder("::", ">>> Date Format Requirements <<<::06/25/2016::or::06252016") + "\n");
    }

    // *************************************************************************************************************** Headers UI
    public void header_ListAll() {
        io.display(gui.os_Quick_Header_Builder("List All Orders") + "\n");
    }

    public void header_Add() {
        io.display(gui.os_Quick_Header_Builder("Add New Order") + "\n");
    }

    public void header_Edit() {
        io.display(gui.os_Quick_Header_Builder("Edit Order") + "\n");
    }

    public void header_Remove() {
        io.display(gui.os_Quick_Header_Builder("Remove Order") + "\n");
    }

    public void header_Save() {
        io.display(gui.os_Quick_Header_Builder("Save data to the local database") + "\n");
    }
}
