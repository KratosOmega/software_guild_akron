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
public class FMPProductDao {

    private Map<String, Product> products;
    private Scanner productsReader;

    public FMPProductDao() {
        this.products = new HashMap<>();

        try {
            this.productsReader = new Scanner(new BufferedReader(new FileReader("db_products.txt")));

            String[] productRecord;

            while (productsReader.hasNext()) {
                productRecord = productsReader.nextLine().split(",");
                this.products.put(productRecord[0], new Product(productRecord[0], Double.parseDouble(productRecord[1]), Double.parseDouble(productRecord[2])));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Damn!");
        }
    }

    public Map<String, Product> getProducts() {
        return products;
    }
}
