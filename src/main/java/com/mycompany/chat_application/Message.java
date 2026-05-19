/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat_application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        
    do{
        System.out.println();
        System.out.println("""
                           ***Welcoome to QuickChat***
                           Choose an Option (1-3)
                           Option1 : Send Messages 
                           Option2 : Show recently sent messages  
                           Option3 : Quit""");
        Option = scanner.nextInt();
        scanner.nextLine();
        
        switch(Option){
            
            case 1: sendMesseges();
                break;
            case 2: System.out.println("COMING SOON: Still under development ");
                break;
            case 3: System.out.println("GOOD BYE");
                break;
            default: System.out.println("Please enter a valid option from 1 - 3");
        }
            
    }while(Option != 3);    
    
}
    public void sendMesseges(){
        System.out.println("Enter the cellphone you want to send the message to");
        String recipientCellNumber = scanner.nextLine();
        boolean rightCellNumber = checkRecipientCellphoneNum(recipientCellNumber);
        
        if(rightCellNumber){
            
            int numberOfMessages;
            System.out.println("How many messages would you like to send");
            numberOfMessages = scanner.nextInt();
            scanner.nextLine();
            
            
            for(int i =1; i<= numberOfMessages; i++){
                
                System.out.println();
                System.out.println("Enter message number "+ i + " (Must be less than 250 characters)");
                String message = scanner.nextLine();
                
                String result = sentMessage(i, message, recipientCellNumber);
                
                System.out.println(result);
            }

            int tota_messages = totalMessages(totalMessages);
            System.out.println("The total number of messages sent is : " + tota_messages);
            System.out.println();
            
            
        }
        else{
            System.out.println("Cellphone is not correctly formated or does not contain international code");
        }
    }
    
    public String sentMessage(int numOfMessage, String message, String recipientCellNumber){
        
        System.out.println("""
                           Choose what to do with the massege reply with a number (0-2)
                            Option 0 : Delete Message
                            Option 1 : Send Message 
                            Option 2 : Store Message  
                            """);
        
        String option = scanner.nextLine();
        System.out.println();
        
        long messageId = createMessageId();
        String messageHash = createMessageHash(messageId, numOfMessage, message);
        
        if(option.equals("1")){

            System.out.println("Message ID : "+ messageId + 
                    "\nMessageHash : "+ messageHash +
                    "\nRecipient : "+ recipientCellNumber + 
                    "\nMessage : " + message); 
            System.out.println();
            totalMessages++;
            return "Message Sent Successfully";
            
        }
        else if(option.equals("2")){
            try{
                storeMessage(message, messageId, messageHash, recipientCellNumber);
            }catch(IOException e){
                System.out.println("Could not store message");
            }
            return "Message successfully stored";
        }
        else if(option.equals("0")){
            return "Message deleted";
        }
     
            
       return "Invalid option";
    }
    
    public void storeMessage(String message, long id, String hash, String recipientCell) throws IOException{
        
        String path = "messages.json";
        File file = new File(path);
        
        String newInfo = "{\n"+
                            "\"message\"  : \"" +message+"\",\n" + 
                            "\"recipient\": \"" +recipientCell +"\",\n" +
                            "\"messageID\": \""+id+"\",\n" +
                            "\"messageHash\": \"" +hash+"\"\n" +
                            "}";
        
        //using the file object to check if the file exist
        if(!file.exists()){
            //file writer will create the file to the path if the file doesnot exist
            FileWriter writefile = new FileWriter(path);
            
            //Printwriter will let me write info on the file with writer.print
            PrintWriter writer = new PrintWriter(writefile);
            
            //the format of json files is that they must start with [ and end with ]
            writer.println("[");
            writer.println(newInfo);
            writer.println("]");
            
            writer.close();
        }
        else{
           
            //the file object will open the file and the buffered reader object will help read the file effectively
            FileReader readfile = new FileReader(path);
            BufferedReader reader = new BufferedReader(readfile);
            
            String line;
            String storedFile = "";
            
            while((line = reader.readLine()) != null){
                storedFile = storedFile + line + "\n";
            }
            reader.close();
            
            storedFile = storedFile.trim();
            if(storedFile.length() > 1){
                storedFile = storedFile.substring(0, storedFile.length() - 1);
                storedFile = storedFile + ",";
            }
            
            
            FileWriter writefile = new FileWriter(path);
            PrintWriter writer = new PrintWriter(writefile);
            
            writer.println(storedFile);
            writer.println(newInfo);
            writer.println("]");
            
            writer.close();
        }
    }
    
    public int totalMessages(int numberOfMessages) {
        
        return numberOfMessages;
    }
    public String createMessageHash(long id, int numOfMessage, String message){
        
       String ID = Long.toString(id);
       String firstTwoNUm = ID.substring(0, 2);
       
       int firstSpace = message.indexOf(" ");
       String firstWord = message.substring(0, firstSpace).toUpperCase();
       
       int lastSpace = message.lastIndexOf(" ");
       String lastWord = message.substring(lastSpace + 1).toUpperCase();
       
       return firstTwoNUm + ":" + numOfMessage +":"+ firstWord + lastWord;
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
