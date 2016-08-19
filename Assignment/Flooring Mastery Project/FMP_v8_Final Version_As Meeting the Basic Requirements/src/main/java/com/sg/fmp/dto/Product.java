/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fmp.dto;

/**
 *
 * @author Kratos
 */
public class Product {
    private String productType;
    private double costPerSqrtFoot;
    private double laborCostPerSqrtFoot;

    public Product(String productType, double costPerSqrtFoot, double laborCostPerSqrtFoot) {
        this.productType = productType;
        this.costPerSqrtFoot = costPerSqrtFoot;
        this.laborCostPerSqrtFoot = laborCostPerSqrtFoot;
    }

    public String getProductType() {
        return productType;
    }

    public double getCostPerSqrtFoot() {
        return costPerSqrtFoot;
    }

    public double getLaborCostPerSqrtFoot() {
        return laborCostPerSqrtFoot;
    }
}
