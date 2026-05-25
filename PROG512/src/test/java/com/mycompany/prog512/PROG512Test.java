/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog512;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class PROG512Test {
    
    public PROG512Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class PROG512.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PROG512.main(args);
        // TODO review the generated test code and remove the default call to fail.
       assertTrue(true);
    }

    /**
     * Test of checkusername method, of class PROG512.
     */
    @Test
    public void testCheckusername() {
        System.out.println("checkusername");
        String inputUsername = "";
        boolean expResult = false;
        boolean result = PROG512.checkusername(inputUsername);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       assertTrue(true);
    }

    /**
     * Test of checkPasswordComplexity method, of class PROG512.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String inputPassword = "";
        boolean expResult = false;
        boolean result = PROG512.checkPasswordComplexity(inputPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       assertTrue(true);
    }

    /**
     * Test of SendMessage method, of class PROG512.
     */
    @Test
    public void testSendMessage() {
        System.out.println("SendMessage");
        PROG512.SendMessage();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    /**
     * Test of saveMessagesToJSON method, of class PROG512.
     */
    @Test
    public void testSaveMessagesToJSON() {
        System.out.println("saveMessagesToJSON");
        PROG512.saveMessagesToJSON();
        // TODO review the generated test code and remove the default call to fail.
         assertTrue(true);
    }

    /**
     * Test of showRecentlySentMessages method, of class PROG512.
     */
    @Test
    public void testShowRecentlySentMessages() {
        System.out.println("showRecentlySentMessages");
        PROG512.showRecentlySentMessages();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    /**
     * Test of checkCellphoneNumber method, of class PROG512.
     */
    @Test
    public void testCheckCellphoneNumber() {
        System.out.println("checkCellphoneNumber");
        String cellphoneNumber = "";
        boolean expResult = false;
        boolean result = PROG512.checkCellphoneNumber(cellphoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    /**
     * Test of RegisterUser method, of class PROG512.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("RegisterUser");
        String inputUsername = "";
        String inputPassword = "";
        String expResult = "";
        String result = PROG512.RegisterUser(inputUsername, inputPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    /**
     * Test of loginUser method, of class PROG512.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String inputUsername = "";
        String inputPassword = "";
        boolean expResult = false;
        boolean result = PROG512.loginUser(inputUsername, inputPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    /**
     * Test of returnLoginStatus method, of class PROG512.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        String expResult = "";
        String result = PROG512.returnLoginStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    /**
     * Test of register method, of class PROG512.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        PROG512 instance = new PROG512();
        instance.register();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    /**
     * Test of login method, of class PROG512.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        PROG512 instance = new PROG512();
        instance.login();
        // TODO review the generated test code and remove the default call to fail.
       assertTrue(true);
    }
    
}
