/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kratos
 */
public class BankManagerDAOTest {

    @Test
    public void checkPassWordTest_1() {
        // Arrange
        String password = "Kratos";
        boolean expected = true;
        // Act
        BankManagerDAO dao = new BankManagerDAO();
        boolean actual = dao.checkPassWord(password);
        // Assert		
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPassWordTest_2() {
        // Arrange
        String password = "123";
        boolean expected = false;
        // Act
        BankManagerDAO dao = new BankManagerDAO();
        boolean actual = dao.checkPassWord(password);
        // Assert		
        org.junit.Assert.assertEquals(expected, actual);
    }
}
