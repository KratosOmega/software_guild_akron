/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fmp.dto;

import com.sg.fmp.dao.EncodeCommaInName;

/**
 *
 * @author Kratos
 */
public class Order {

    private int orderNumber;
    private boolean orderStatus;
    private String customerName;
    private String state;
    private double taxRate;
    private String productType;
    private double area;
    private double costPerSqrtFoot;
    private double laborCostPerSqrtFoot;
    private double materialCost;
    private double laborCost;
    private double tax;
    private double total;

    public Order(int orderNumber, boolean orderStatus, String customerName, String state, double taxRate, String productType, double area, double costPerSqrtFoot, double laborCostPerSqrtFoot, double materialCost, double laborCost, double tax, double total) {
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
        this.customerName = customerName;
        this.state = state;
        this.taxRate = taxRate;
        this.productType = productType;
        this.area = area;
        this.costPerSqrtFoot = costPerSqrtFoot;
        this.laborCostPerSqrtFoot = laborCostPerSqrtFoot;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.tax = tax;
        this.total = total;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCostPerSqrtFoot() {
        return costPerSqrtFoot;
    }

    public void setCostPerSqrtFoot(double costPerSqrtFoot) {
        this.costPerSqrtFoot = costPerSqrtFoot;
    }

    public double getLaborCostPerSqrtFoot() {
        return laborCostPerSqrtFoot;
    }

    public void setLaborCostPerSqrtFoot(double laborCostPerSqrtFoot) {
        this.laborCostPerSqrtFoot = laborCostPerSqrtFoot;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost() {
        this.materialCost = this.area * this.costPerSqrtFoot;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost() {
        this.laborCost = this.area * this.laborCostPerSqrtFoot;
    }

    public double getTax() {
        return tax;
    }

    public void setTax() {
        this.tax = (this.laborCost + this.materialCost) * this.taxRate / 100;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = this.laborCost + this.materialCost + this.tax;
    }

    // ************************************************* Customized
//    public String encodedAttributes() {
//        return this.orderNumber + ","
//                + this.getOrderStatus() + ","
//                + this.customerName + ","
//                + this.state + ","
//                + this.taxRate + ","
//                + this.productType + ","
//                + this.area + ","
//                + this.costPerSqrtFoot + ","
//                + this.laborCostPerSqrtFoot + ","
//                + this.materialCost + ","
//                + this.laborCost + ","
//                + this.tax + ","
//                + this.total;
//    }
    
    // Get a override method for special case of haing a comma in name
    EncodeCommaInName encodeCommaInName = new EncodeCommaInName() {
            @Override
            public String encodeComma(String customerName) {
                if (customerName.contains(",")) {
                    String[] nameComponents = customerName.split(",");
                    String returnedName = "";

                    for (int i = 0; i < nameComponents.length; i++) {
                        if (i != nameComponents.length-1) {
                            returnedName += nameComponents[i] + "@";
                        } else {
                            returnedName += nameComponents[i];
                        }
                    }
                    return returnedName;

                } else {
                    return customerName;
                }
            }
        };
    
    public String encodedAttributes() {
        return this.orderNumber + ","
                + this.getOrderStatus() + ","
                + encodeCommaInName.encodeComma(this.customerName) + ","
                + this.state + ","
                + this.taxRate + ","
                + this.productType + ","
                + this.area + ","
                + this.costPerSqrtFoot + ","
                + this.laborCostPerSqrtFoot + ","
                + this.materialCost + ","
                + this.laborCost + ","
                + this.tax + ","
                + this.total;
    }

    public String showOrderStatus() {
        if (this.isOrderStatus()) {
            return "Active";
        } else {
            return "Archive";
        }
    }

    public String getOrderStatus() {
        if (this.isOrderStatus()) {
            return "true";
        } else {
            return "false";
        }
    }
}
