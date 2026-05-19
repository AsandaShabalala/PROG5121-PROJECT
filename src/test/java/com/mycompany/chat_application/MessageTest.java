/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chat_application;

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
public class MessageTest {
    
    public MessageTest() {
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
     * Test of Messaging method, of class Message.
     */
    @Test
    public void testMessaging() {
        System.out.println("Messaging");
        Message instance = new Message();
        instance.Messaging();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMesseges method, of class Message.
     */
    @Test
    public void testSendMesseges() {
        System.out.println("sendMesseges");
        Message instance = new Message();
        instance.sendMesseges();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sentMessage method, of class Message.
     */
    @Test
    public void testSentMessage() {
        System.out.println("sentMessage");
        int numOfMessage = 0;
        String message = "";
        String recipientCellNumber = "";
        Message instance = new Message();
        String expResult = "";
        String result = instance.sentMessage(numOfMessage, message, recipientCellNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class Message.
     */
    @Test
    public void testStoreMessage() throws Exception {
        System.out.println("storeMessage");
        String message = "";
        long id = 0L;
        String hash = "";
        String recipientCell = "";
        Message instance = new Message();
        instance.storeMessage(message, id, hash, recipientCell);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totalMessages method, of class Message.
     */
    @Test
    public void testTotalMessages() {
        System.out.println("totalMessages");
        int numberOfMessages = 0;
        Message instance = new Message();
        int expResult = 0;
        int result = instance.totalMessages(numberOfMessages);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        long id = 0L;
        int numOfMessage = 0;
        String message = "";
        Message instance = new Message();
        String expResult = "";
        String result = instance.createMessageHash(id, numOfMessage, message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageId method, of class Message.
     */
    @Test
    public void testCreateMessageId() {
        System.out.println("createMessageId");
        Message instance = new Message();
        long expResult = 0L;
        long result = instance.createMessageId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCellphoneNum method, of class Message.
     */
    @Test
    public void testCheckRecipientCellphoneNum() {
        System.out.println("checkRecipientCellphoneNum");
        String cellPhoneNumber = "";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkRecipientCellphoneNum(cellPhoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        String messageId = "";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkMessageID(messageId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
