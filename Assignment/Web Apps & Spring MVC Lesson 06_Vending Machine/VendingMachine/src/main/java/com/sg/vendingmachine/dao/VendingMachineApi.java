/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.model.Change;

/**
 *
 * @author Kratos
 */
public interface VendingMachineApi {
    public int isMoneyEnought(int selection, int insertedMoney);
    
    public Change makeChange(int diff);
}
