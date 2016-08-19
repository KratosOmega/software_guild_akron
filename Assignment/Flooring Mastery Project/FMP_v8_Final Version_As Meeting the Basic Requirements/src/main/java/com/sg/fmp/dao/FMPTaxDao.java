/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fmp.dao;

import com.sg.fmp.dto.Product;
import com.sg.fmp.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Kratos
 */
public class FMPTaxDao {

    private Map<String, Tax> taxes;
    private Scanner taxesReader;

    public FMPTaxDao() {

        this.taxes = new HashMap<>();

        try {
            this.taxesReader = new Scanner(new BufferedReader(new FileReader("db_taxes.txt")));

            String[] taxRecord;

            while (taxesReader.hasNext()) {
                taxRecord = taxesReader.nextLine().split(",");
                this.taxes.put(taxRecord[0], new Tax(taxRecord[0], Double.parseDouble(taxRecord[1])));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Damn!");
        }
    }

    public Map<String, Tax> getTaxes() {
        return taxes;
    }

}
