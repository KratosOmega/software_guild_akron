/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fmp.dao;

import com.sg.fmp.dto.Order;
import java.util.List;

/**
 *
 * @author Kratos
 */
public interface FMPApi {
    List<Order> listOrders(String date);
    
    void addOrder(Order newOrder);
    
    Order editOrder(String key, Order editedOrder);
    
    void removeOrder(String date, String orderNumber);
    
    boolean saveCurrentWork();
}
