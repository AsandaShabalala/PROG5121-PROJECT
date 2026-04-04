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
        
        if(checkRecipientCellphoneNum(recipientCellNumber)){
            
            int numberOfMessages;
            
            System.out.println("How many messages would you like to send");
            numberOfMessages = scanner.nextInt();
            for(int i = 1; i <= numberOfMessages; i++){
                System.out.println("Enter the message you want to send (Must be less than 250 characters)");
                String message = scanner.nextLine();
                
                long messageId = createMessageId();
                createMessageHash(messageId, i, message);
                
        }
            
            
        }
        else{
            System.out.println("Cellphone is not correctly formated or does not contain international code");
        }
    }
    
    public String createMessageHash(long id, int numOfMessage, String message){
        
       String ID = Long.toString(id);
       String firstTwoNUm = ID.substring(0, 2);
       
       int firstSpace = message.indexOf(" ");
       String firstWord = message.substring(0, firstSpace).toUpperCase();
       
       int lastSpace = message.lastIndexOf(" ");
       String lastWord = message.substring(lastSpace + 2).toUpperCase();
       
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
