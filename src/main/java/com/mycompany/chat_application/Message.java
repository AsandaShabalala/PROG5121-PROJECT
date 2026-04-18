/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat_application;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class Message {
    Scanner scanner = new Scanner(System.in);
    int totalMessages = 0;
    
    void Messaging(){
        int Option;
        
        
        System.out.println("***Welcoome to QuickChat***\nOption1 : Send Messages"
                                + " \nOption2: Show recently sent messages  "
                                + "\nOption3: Quit");
        Option = scanner.nextInt();
        scanner.nextLine();
        
        switch(Option){
            
            case 1: 
                
                
                break;
            case 2: System.out.println("COMING SOON: Still under development ");
                break;
            case 3: System.out.println("GOOD BYE");
                break;
            default: System.out.println("Please enter a valid option from 1 - 3");
        }
            
        
    
}
    public void sendMesseges(){
        System.out.println("Enter the cellphone you want to send the message to");
        String recipientCellNumber = scanner.nextLine();
        boolean rightCellNumber = checkRecipientCellphoneNum(recipientCellNumber);
        
        if(rightCellNumber){
            
            int numberOfMessages;
            System.out.println("How many messages would you like to send");
            numberOfMessages = scanner.nextInt();
            
            int messageCounter = 1;
            while(messageCounter <= numberOfMessages){
                
                System.out.println("Enter message number "+ messageCounter + " you want to send (Must be less than 250 characters)");
                String message = scanner.nextLine();
                
                sentMessage(messageCounter, message, recipientCellNumber);
                
                messageCounter++;
            }
            int tota_messages = totalMessages(totalMessages);
            System.out.println("The total number of messages sent is : " + tota_messages);
            
            
        }
        else{
            System.out.println("Cellphone is not correctly formated or does not contain international code");
        }
    }
    
    public String sentMessage(int numOfMessage, String message, String recipientCellNumber){
        
        System.out.println("""
                           Choose what to do with the massege reply with a number (1-3)
                            Option 1 : Send Message 
                            Option 2 : Store Message  
                            Option 3 : Disregard Message""");
        String option = scanner.nextLine();
        
        if(option.equals("1")){
            
            
            long messageId = createMessageId();
            String messageHash = createMessageHash(messageId, numOfMessage, message);
            
            System.out.println("Message ID : "+ messageId + 
                    "\nMessageHash : "+ messageHash +
                    "\nRecipient : "+ recipientCellNumber + 
                    "\nMessage : " + message);
            
            totalMessages++;
            return "Message Sent Successfully";
        }
        
     
            
       return null;     
    }
    
    public int totalMessages(int numberOfMessages){
        
        return numberOfMessages;
    }
    public String createMessageHash(long id, int numOfMessage, String message){
        
       String ID = Long.toString(id);
       String firstTwoNUm = ID.substring(0, 2);
       
       int firstSpace = message.indexOf(" ");
       String firstWord = message.substring(0, firstSpace).toUpperCase();
       
       int lastSpace = message.lastIndexOf(" ");
       String lastWord = message.substring(lastSpace + 1).toUpperCase();
       
       return firstTwoNUm + ":" + numOfMessage + firstWord + lastWord;
    }
     
    public long createMessageId(){
        long id = 1_000_000_000L + (long)(Math.random() * 9_000_000_000L);
        return id;
    }
    public boolean checkRecipientCellphoneNum(String cellPhoneNumber){
        
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }
    public boolean checkMessageID(String messageId){
        return messageId.length() <= 10;
    }
}
