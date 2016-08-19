/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.model.Change;
import com.sg.vendingmachine.model.Item;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.tree.RowMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Kratos
 */
public class VendingMachineImpl implements VendingMachineApi {

    private JdbcTemplate jdbcTemplate;

    // DI by using setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_SELECT_ITEMS = "SELECT item_id, item_name, item_price, item_quantity FROM item WHERE item_quantity > 0";
    private static final String SQL_SELECT_ITEM_BY_ITEM_ID = "SELECT item_id, item_name, item_price, item_quantity FROM item WHERE item_id = ?";
    private static final String SQL_UPDATE_ITEM = "UPDATE item SET item_name = ?, item_price = ?, item_quantity = ? WHERE item_id = ?";

    @Override
    public Change makeChange(int diff) {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int cents = 0;

        do {
            if (diff >= 25) {
                quarters = ((diff - (diff % 25))) / 25;
                diff = diff % 25;
            } else if (diff >= 10) {
                dimes = ((diff - (diff % 10))) / 10;
                diff = diff % 10;
            } else if (diff >= 5) {
                nickels = ((diff - (diff % 5))) / 5;
                diff = diff % 5;
            } else {
                cents = diff;
                diff = 0;
            }
        } while (diff != 0);

        Change change = new Change(quarters, dimes, nickels, cents);

        return change;
    }

    @Override
    public List<Item> listAllAvailableItems() {
        return jdbcTemplate.query(SQL_SELECT_ITEMS, new ItemMapper());
    }

    @Override
    public Item listItemById(int item_id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ITEM_BY_ITEM_ID, new ItemMapper(), item_id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void editItem(Item item) {
        jdbcTemplate.update(SQL_UPDATE_ITEM,
                item.getItem_name(),
                item.getItem_price(),
                item.getItem_quantity(),
                item.getItem_id());
    }

    // Mapper
    private static final class ItemMapper implements org.springframework.jdbc.core.RowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int i) throws SQLException {
            Item item = new Item();
            item.setItem_id(rs.getInt("item_id"));
            item.setItem_name(rs.getString("item_name"));
            item.setItem_price(rs.getDouble("item_price"));
            item.setItem_quantity(rs.getInt("item_quantity"));

            return item;
        }
    }

}
