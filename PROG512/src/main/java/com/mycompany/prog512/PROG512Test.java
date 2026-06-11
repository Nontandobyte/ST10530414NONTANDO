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

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of Checkusername method, of class PROG512.
     */
    @org.junit.jupiter.api.Test
    public void testCheckusername() {
        System.out.println("checkusername");
        String inputUsername = "kyl_1";
        boolean expResult =true;
        boolean result = PROG512.checkusername(inputUsername);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class PROG512.
     */
    @org.junit.jupiter.api.Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String inputPassword = "Ch&&sec@ke99!";
        boolean expResult = true;
        boolean result = PROG512.checkPasswordComplexity(inputPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkCellphoneNumber method, of class PROG512.
     */
    @org.junit.jupiter.api.Test
    public void testCheckCellphoneNumber() {
        System.out.println("checkCellphoneNumber");
        String cellphoneNumber = "+27838968976";
        boolean expResult = true;
        boolean result = PROG512.checkCellphoneNumber(cellphoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of RegisterUser method, of class PROG512.
     */
    @org.junit.jupiter.api.Test
    public void testRegisterUser() {
        System.out.println("RegisterUser");
        String inputUsername = "kyl_1";
        String inputPassword = "Ch&&sec@ke99!";
        String expResult = "user has been registered successfully.";
        String result = PROG512.RegisterUser(inputUsername, inputPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class PROG512.
     */
    @org.junit.jupiter.api.Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String inputUsername = "kyl_1";
        String inputPassword = "Ch&&sec@ke99!";
        boolean expResult = false;
        boolean result = PROG512.loginUser(inputUsername, inputPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of returnLoginStatus method, of class PROG512.
     */
    @org.junit.jupiter.api.Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        String expResult = "welcome,it is great to see you again";
        String result = PROG512.returnLoginStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class PROG512.
     */
    @org.junit.jupiter.api.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PROG512.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class PROG512.
     */
    @org.junit.jupiter.api.Test
    public void testRegister() {
        System.out.println("register");
        PROG512 instance = new PROG512();
        instance.register();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class PROG512.
     */
    @org.junit.jupiter.api.Test
    public void testLogin() {
        System.out.println("login");
        PROG512 instance = new PROG512();
        instance.login();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
