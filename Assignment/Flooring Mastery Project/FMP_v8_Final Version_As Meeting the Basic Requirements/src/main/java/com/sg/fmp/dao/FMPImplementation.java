/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fmp.dao;

import com.sg.fmp.dto.Order;
import com.sg.fmp.dto.Product;
import com.sg.fmp.dto.Tax;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Kratos
 */
public class FMPImplementation implements FMPApi {

    private int currentOrderNumber;
    private String date;
    private List<String> importedList;
    private FMPTaxDao taxes;
    private FMPProductDao products;

    private Map<String, Order> orders; // <String for encoded string "Date::orderNumber", List for Order object 

    private Scanner ordersReader;
    private final String filePathTo_database_orderSet;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Snapshot related Data
    private int addCount;
    private int editCount;
    private int removeCount;
    private final String filePathTo_database_snapshot;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Snapshot related Data

    public FMPImplementation() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        this.date = dateFormat.format(currentDate);
        importedList = new ArrayList<>();

        this.orders = new HashMap<>();
        this.filePathTo_database_orderSet = "./_database/_orderSet/";
        this.filePathTo_database_snapshot = "./_database/_snapshot/";
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Snapshot related Data
        this.addCount = 0;
        this.editCount = 0;
        this.removeCount = 0;
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Snapshot related Data

        // polulate the products & tax in database
        taxes = new FMPTaxDao();
        products = new FMPProductDao();

        // get the next order number from today's order list
        // also retrive today's order list if it exist
        this.currentOrderNumber = this.retrieveDataFromDatabase(this.date);

    }

    // ******************************************************** Customized Methods
    public String keyEncoder(String date, String orderNumber) {
        return date + "::" + orderNumber;
    }

    public String keyDecoder_getDate(String encodedString) {
        return encodedString.split("::")[0];
    }

    public String keyDecoder_getOrderNumber(String encodedString) {
        return encodedString.split("::")[1];
    }

    public String fileName_Generator(String givenDate) {
        return "Orders_" + givenDate + ".txt";
    }

    

    public int retrieveDataFromDatabase(String givenDate) {
        int nextIndex = 0;
        try {
            this.ordersReader = new Scanner(new BufferedReader(new FileReader(this.filePathTo_database_orderSet + this.fileName_Generator(givenDate))));

            while (ordersReader.hasNext()) {
                String[] orderRecord = ordersReader.nextLine().split(",");
                this.orders.put(keyEncoder(givenDate, orderRecord[0]), new Order(
                        Integer.parseInt(orderRecord[0]),
                        Boolean.parseBoolean(orderRecord[1]),
                        decodeCommaInName.decodeComma(orderRecord[2]),
                        orderRecord[3],
                        Double.parseDouble(orderRecord[4]),
                        orderRecord[5],
                        Double.parseDouble(orderRecord[6]),
                        Double.parseDouble(orderRecord[7]),
                        Double.parseDouble(orderRecord[8]),
                        Double.parseDouble(orderRecord[9]),
                        Double.parseDouble(orderRecord[10]),
                        Double.parseDouble(orderRecord[11]),
                        Double.parseDouble(orderRecord[12])));

                nextIndex = Integer.parseInt(orderRecord[0]) + 1;
            }

            importedList.add(this.fileName_Generator(givenDate));
        } catch (FileNotFoundException e) {
            return 1;
        }
        return nextIndex;
    }

    public boolean checkDatabaseExistence(String givenDate) {

        try {
            Scanner orderReader = new Scanner(new BufferedReader(new FileReader(this.filePathTo_database_orderSet + this.fileName_Generator(givenDate))));
            return true;

        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public boolean checkImportedListExistence(String givenDate) {
        String fileName = this.fileName_Generator(givenDate);

        return !(this.importedList
                .stream()
                .filter(file -> file.equals(fileName))
                .collect(Collectors.toList())
                .isEmpty());
    }

    public boolean checkMemoryExistence(String givenDate) {
        return !this.orders
                .keySet()
                .stream()
                .filter(key -> this.keyDecoder_getDate(key).equals(givenDate))
                .collect(Collectors.toList())
                .isEmpty();
    }

    public String decodeDate(String givenDate) {
        if (givenDate.length() < 10) {
            return givenDate;
        } else {
            String[] dateComponentList = givenDate.split("/");
            return dateComponentList[0] + dateComponentList[1] + dateComponentList[2];
        }
    }

//    public String encodeDate(String givenDate) {
//        return givenDate.substring(0, 2) + "/" + givenDate.substring(2, 4) + "/" + givenDate.substring(4, givenDate.length());
//    }
    // ********************************************************* API Implementation
    @Override
    public List<Order> listOrders(String givenDate) {
        List<Order> returnOrders = new ArrayList<>();

        // First check whether the orders are current day's records which have not been updated to the database
        List<String> keySet = this.orders
                .keySet()
                .stream()
                .filter(key -> this.keyDecoder_getDate(key).equals(givenDate))
                .collect(Collectors.toList());

        // If in memory, nothing is founded, that means we need to go database to load the data
        if (keySet.isEmpty()) {
            try {
                Scanner orderReader = new Scanner(new BufferedReader(new FileReader(this.filePathTo_database_orderSet + this.fileName_Generator(givenDate))));

                while (orderReader.hasNext()) {
                    String[] orderRecord = orderReader.nextLine().split(",");
                    returnOrders.add(new Order(
                            Integer.parseInt(orderRecord[0]),
                            Boolean.parseBoolean(orderRecord[1]),
                            decodeCommaInName.decodeComma(orderRecord[2]),
                            orderRecord[3],
                            Double.parseDouble(orderRecord[4]),
                            orderRecord[5],
                            Double.parseDouble(orderRecord[6]),
                            Double.parseDouble(orderRecord[7]),
                            Double.parseDouble(orderRecord[8]),
                            Double.parseDouble(orderRecord[9]),
                            Double.parseDouble(orderRecord[10]),
                            Double.parseDouble(orderRecord[11]),
                            Double.parseDouble(orderRecord[12])));
                }
            } catch (FileNotFoundException e) {
                return null;
            }
        } else {
            keySet
                    .stream()
                    .forEach(key -> returnOrders.add(this.orders.get(key)));
        }

        // Return sorted orders on particular date
        return returnOrders
                .stream()
                // --------------------------------------------------- ??? Might gonna duplicate with a ui method
                .filter(order -> order.isOrderStatus())
                // --------------------------------------------------- ???
                .sorted((order1, order2) -> order1.getOrderNumber() - order2.getOrderNumber())
                .collect(Collectors.toList());
    }

    @Override
    public void addOrder(Order newOrder) {
        this.orders.put(this.keyEncoder(this.date, newOrder.getOrderNumber() + ""), newOrder);
        this.currentOrderNumber++;
        this.addCount++;
    }

    @Override
    public Order editOrder(String key, Order editedOrder) {
        this.orders.put(key, editedOrder);
        this.editCount++;
        return editedOrder;
    }

    public Order preEditOrder(Order editedOrder) {
        editedOrder.setTaxRate(this.taxes.getTaxes().get(editedOrder.getState()).getTaxRate());
        editedOrder.setCostPerSqrtFoot(this.products.getProducts().get(editedOrder.getProductType()).getCostPerSqrtFoot());
        editedOrder.setLaborCostPerSqrtFoot(this.products.getProducts().get(editedOrder.getProductType()).getLaborCostPerSqrtFoot());
        editedOrder.setMaterialCost();
        editedOrder.setLaborCost();
        editedOrder.setTax();
        editedOrder.setTotal();
        return editedOrder;
    }

    @Override
    public void removeOrder(String givenDate, String orderNumber) {
        String key = this.keyEncoder(givenDate, orderNumber + "");
        this.orders.get(key).setOrderStatus(false);
        this.removeCount++;
    }

    @Override
    public boolean saveCurrentWork() {

        Map<String, String> refactoredDatabase = new HashMap<>();

        this.orders.keySet()
                .stream()
                .forEach(key -> { // take all the keys of all the record in memory
                    String fileName = this.fileName_Generator(this.keyDecoder_getDate(key));
                    // Here I concentraction all the records within same day to be a single string, 
                    // thus, it can be stored under a unique file name in the hashmap

                    if (refactoredDatabase.isEmpty() || !refactoredDatabase.containsKey(fileName)) {
                        refactoredDatabase.put(fileName, orders.get(key).encodedAttributes());
                    } else {
                        refactoredDatabase.put(fileName, refactoredDatabase.get(fileName) + "\n" + orders.get(key).encodedAttributes());
                    }
                });

        refactoredDatabase.keySet()
                .stream()
                .forEach(fileName -> {
                    try {
                        PrintWriter writer = new PrintWriter(new FileWriter(this.filePathTo_database_orderSet + fileName));
                        writer.print(refactoredDatabase.get(fileName));
                        writer.flush();
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("Damn!");
                    }
                });
        return true;
    }

    // ****************************** Getters
    public int getCurrentOrderNumber() {
        return currentOrderNumber;
    }

    public Map<String, Product> getProducts() {
        return products.getProducts();
    }

    public Map<String, Tax> getTaxes() {
        return taxes.getTaxes();
    }

    public Map<String, Order> getOrders() {
        return orders;
    }

    public String getFilePathTo_database_orderSet() {
        return filePathTo_database_orderSet;
    }

    public String getFilePathTo_database_snapshot() {
        return filePathTo_database_snapshot;
    }

    
    // Create a override method to decode the customerName getted from local txt file
    // change it into normal name with ","
    // Also applie lambda to this 
    DecodeCommaInName decodeCommaInName = (String customerName) -> {
        if (customerName.contains("@")) {
            String[] nameComponents = customerName.split("@");
            String returnedName = "";
            
            for (int i = 0; i < nameComponents.length; i++) {
                if (i != nameComponents.length-1) {
                    returnedName += nameComponents[i] + ",";
                } else {
                    returnedName += nameComponents[i];
                }
            }
            return returnedName;
            
        } else {
            return customerName;
        }
    };
    // **************************************************************************** Additional Features For fun
    // ********************************************************** Snapshot Section
    // | --> is the snapshot data separator
    // * --> is the general data separator: snapshot infor * data infor
    // :: --> is the filename & order infor separator
    // , --> is the order infor data separator
    // <> --> is the order set separator
    // \n --> is the individual separator
    public void createSnapshot() {
        int nextSnapshotID = 0;
        String snapshotRecord = "";
        String snapshotData = "";
        String orderSetData = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");
        String snapshotDate = dateFormat.format(new Date());
        snapshotData += snapshotDate + "|" + this.addCount + "|" + this.editCount + "|" + this.removeCount + "*";


        /*
        File folder = new File("your/path");
File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
      }
    }
         */
        // Scan all the files in the system
        File foler_snapshot = new File(this.filePathTo_database_snapshot);
        // Get next snapshot ID #
        nextSnapshotID = foler_snapshot.listFiles().length + 1;

        File folder_orderSet = new File(this.filePathTo_database_orderSet);
        File[] listofFiles = folder_orderSet.listFiles();

        for (int i = 0; i < listofFiles.length; i++) {
            File file = listofFiles[i];
            if (file.isFile() && file.getName().endsWith(".txt") && file.getName().startsWith("Orders_")) {
                if (i == 0) {
                    orderSetData += file.getName() + "::";
                } else {
                    orderSetData += "<>" + file.getName() + "::";
                }

                try {
                    boolean isFirstLine = true;
                    Scanner snapshotReader = new Scanner(new BufferedReader(new FileReader(this.filePathTo_database_orderSet + file.getName())));
                    while (snapshotReader.hasNext()) {
                        if (isFirstLine) {
                            orderSetData += snapshotReader.nextLine();
                            isFirstLine = false;
                        } else {
                            orderSetData += "\n" + snapshotReader.nextLine();
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File Not Found!");
                }
            }
        }

        snapshotRecord = snapshotData + orderSetData;

        try {
            BufferedWriter snapshotWriter = new BufferedWriter(new FileWriter(this.filePathTo_database_snapshot + "Snapshot_" + nextSnapshotID + ".txt", true));
            snapshotWriter.write(snapshotRecord);
            snapshotWriter.newLine();
            snapshotWriter.flush();
            snapshotWriter.close();
        } catch (IOException e) {
            System.out.println("IOException!");
        }
    }

    public void restoreSnapshot(String snapshotIndex) {
        // Earase all the data in the database
        // restore certain snapshotIndex to the databse
        // earase all the data in the memory
        String snapshotFileName = "Snapshot_" + snapshotIndex + ".txt";
        String snapshotData = "";
        String orderSetsCollection = "";
        String[] orderSetList;
        String fileName = "";
        String orders = "";

        // Delete all order files in _orderSet folder for later restore
        File folder_orderSet = new File(this.filePathTo_database_orderSet);
        File[] listofFiles = folder_orderSet.listFiles();

        for (File file : listofFiles) {
            file.delete();
        }

        // Restore order sets by using snapshotIndex
        try {
            Scanner snapshotReader = new Scanner(new BufferedReader(new FileReader(this.filePathTo_database_snapshot + snapshotFileName)));
            while (snapshotReader.hasNext()) {
                snapshotData += snapshotReader.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }

        PrintWriter restoreWriter;
        // remove the ending newline "\n"
        snapshotData.trim();

        // Assign the order sets
        orderSetsCollection = snapshotData.split("\\*")[1];
        // Assign the order sets to list
        orderSetList = orderSetsCollection.split("<>");
        for (String orderSet : orderSetList) {
            fileName = orderSet.split("::")[0];
            orders = orderSet.split("::")[1];

            try {
                restoreWriter = new PrintWriter(new FileWriter(this.filePathTo_database_orderSet + fileName));
                restoreWriter.print(orders);
                restoreWriter.flush();
                restoreWriter.close();
            } catch (IOException e) {
                System.out.println("IOException!");
            }
        }
    }

    public List<String> listSnapshots() {
        List<String> fileNameList = new ArrayList<>();
        File folder_snapshot = new File(this.filePathTo_database_snapshot);

        // Distribute all the snapshot filename into list
        for (File file : folder_snapshot.listFiles()) {
            if (file.getName().startsWith("Snapshot_")) {
                fileNameList.add(file.getName());
            }
        }

        // Sort the filename list
        return fileNameList
                .stream()
                .sorted((fileName1, fileName2) -> fileName1.compareTo(fileName2))
                .collect(Collectors.toList());

        // retrieve the info. of snapshot
        // Display the snapshot by date with #
        // If particular snapshot is selected
        // then display add, edit, remove count
    }

    public List<String> browseSnapshot(String index) {
        List<String> snapshotInfo = new ArrayList<>();
        String snapshotFileName = "Snapshot_" + index + ".txt";

        try {
            Scanner snapshotReader = new Scanner(new BufferedReader(new FileReader(this.filePathTo_database_snapshot + snapshotFileName)));
            snapshotInfo.addAll(Arrays.asList(snapshotReader.nextLine().split("\\*")[0].split("\\|")));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }

        return snapshotInfo;
    }
}
