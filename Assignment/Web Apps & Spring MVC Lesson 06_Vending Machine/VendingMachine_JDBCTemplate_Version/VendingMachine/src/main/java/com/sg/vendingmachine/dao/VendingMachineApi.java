/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.model.Change;
import com.sg.vendingmachine.model.Item;
import java.util.List;

/**
 *
 * @author Kratos
 */
public interface VendingMachineApi {
    public Change makeChange(int diff);
    public List<Item> listAllAvailableItems();
    public Item listItemById(int item_id);
    public void editItem(Item item);
}
