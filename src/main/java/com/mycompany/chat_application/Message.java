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
 Message class for the QuickChat application
 */
public class Message {
    Scanner scanner = new Scanner(System.in);
    int totalMessages = 0;  //global varibale to count the total messages sent
    
    void Messaging(){
        int Option;
     
     //repeats the menu outputs unitl the user chooses option 3 to quit   
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
        
        //switch case to check the users option and do what the user selected
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
        //checks if the cellphone number was formated correctly before the user sends any messages
        
        if(rightCellNumber){
            
            int numberOfMessages;
            System.out.println("How many messages would you like to send");
            numberOfMessages = scanner.nextInt();
            scanner.nextLine();
            
            //loops until the number of messages set by the user are all sent
            for(int i =1; i<= numberOfMessages; i++){
                
                System.out.println();
                System.out.println("Enter message number "+ i + " (Must be less than 250 characters)");
                String message = scanner.nextLine();
                
                //call the sentMessage() method after every message
                String result = sentMessage(i, message, recipientCellNumber);
                
                System.out.println(result);
            }

            int total_messages = totalMessages(totalMessages);
            System.out.println("The total number of messages sent is : " + total_messages);
            System.out.println();           
        }
        else{
            System.out.println("Cellphone is not correctly formated or does not contain international code");
        }
    }
    
    public String sentMessage(int numOfMessage, String message, String recipientCellNumber){
        
        //asks the user what they want to do with the message
        System.out.println("""
                           Choose what to do with the massege reply with a number (0-2)
                            Option 0 : Delete Message
                            Option 1 : Send Message 
                            Option 2 : Store Message  
                            """);
        
        String option = scanner.nextLine();
        System.out.println();
        
        //create message ID and message Hashcode using the createMessageId()and createMessageHash() methods
        long messageId = createMessageId();
        String messageHash = createMessageHash(messageId, numOfMessage, message);
        
        if(option.equals("1")){

            //displaying message info if the user chooses to send the message
            System.out.println("Message ID : "+ messageId + 
                    "\nMessageHash : "+ messageHash +
                    "\nRecipient : "+ recipientCellNumber + 
                    "\nMessage : " + message); 
            System.out.println();
            totalMessages++;
            return "Message Sent Successfully";
            
        }
        else if(option.equals("2")){
            
            //try and catch block to catch any errors that might when storing the message
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
   
    //method to create the json file to store the message
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
            
            //while the reader is not returning null then we store the existing file in storedFile variable
            while((line = reader.readLine()) != null){
                storedFile = storedFile + line + "\n";
            }
            reader.close();
            
            //trim storedFile to remove things like extra spaces
            storedFile = storedFile.trim();
            
            //removing the "]" and replacing it with "," so new data can be added
            if(storedFile.length() > 1){
                storedFile = storedFile.substring(0, storedFile.length() - 1);
                storedFile = storedFile + ",";
            }
            
            
            FileWriter writefile = new FileWriter(path);
            PrintWriter writer = new PrintWriter(writefile);
            
            //adding the new info onto the storedFile and closing the file with"]"
            writer.println(storedFile);
            writer.println(newInfo);
            writer.println("]");
            
            writer.close();
        }
    }
    
    public int totalMessages(int numberOfMessages) {
        
        return numberOfMessages;
    }
    //creates the messageHash
    public String createMessageHash(long id, int numOfMessage, String message){
        
        //converts the id from a long to a String variable and takes the first two characters
       String ID = Long.toString(id);
       String firstTwoNUm = ID.substring(0, 2);
       
       //gets the first word of the message ny using the index of the first space
       int firstSpace = message.indexOf(" ");
       String firstWord = message.substring(0, firstSpace).toUpperCase();
       
       //gets the last word of the message ny using the index of the last space
       int lastSpace = message.lastIndexOf(" ");
       String lastWord = message.substring(lastSpace + 1).toUpperCase();
       
       return firstTwoNUm + ":" + numOfMessage +":"+ firstWord + lastWord;
    }
     
    // creates a random 10 digit value 
    public long createMessageId(){
        
        //multiplies the random number by 9 billion and set to a long variable to lose the decimals and add 1 billion so we 
        //have a minimum of ten digits
        
        long id = 1_000_000_000L + (long)(Math.random() * 9_000_000_000L);
        return id;
    }
    //checks if the recipientcell is correctly formated
    public boolean checkRecipientCellphoneNum(String cellPhoneNumber){
        
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }
    //checks if the Id is actually 10 digits long
    public boolean checkMessageID(String messageId){
        return messageId.length() == 10;
    }
}
