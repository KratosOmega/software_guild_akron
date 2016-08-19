/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineImpl;
import com.sg.vendingmachine.model.Change;
import com.sg.vendingmachine.model.Item;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Kratos
 */
@Controller
public class VendingMachineController {

    int currentMoneyPool = 0;
    private VendingMachineImpl dao;

    @Inject
    public VendingMachineController(VendingMachineImpl dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "getCurrentInventory", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getCurrentInventory() {
        return dao.listAllAvailableItems();
    }

    @RequestMapping(value = "insert/{selection}/{money}", method = RequestMethod.POST)
    @ResponseBody
    public int insert(@PathVariable("selection") int selection, @PathVariable("money") int money) {
        currentMoneyPool += money;
        int diff = currentMoneyPool - (int) (dao.listItemById(selection).getItem_price() * 100);
        return diff;
    }

    @RequestMapping(value = "change/{diff}", method = RequestMethod.POST)
    @ResponseBody
    public Change change(@PathVariable("diff") int diff) {
        currentMoneyPool = 0;
        return dao.makeChange(diff);
    }

    @RequestMapping(value = "updateInv/{selection}", method = RequestMethod.PUT)
    @ResponseBody
    public List<Item> updateInv(@PathVariable("selection") int selection) {
        Item item = dao.listItemById(selection);
        item.setItem_quantity(item.getItem_quantity() - 1);
        dao.editItem(item);
        return dao.listAllAvailableItems();
    }
}
