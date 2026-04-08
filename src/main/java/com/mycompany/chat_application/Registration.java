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
public class Registration {
    Scanner scanner = new Scanner(System.in);
        
    void register(){
            
        System.out.println("Enter username (MUST CONTAIN an underscore and be 5 characters or less");
        String storedUsername = scanner.nextLine();
        checkUsername(storedUsername);

        System.out.println("Enter password (MUST be atleast 8 characters, contain atleast one number, one Capital letter and one special character: ");
        String storedPassword = scanner.nextLine();
        checkPassword(storedPassword);

        System.out.println("Enter your cellphone number(MUST contain national code(+27) and be ten digits(9 excluding the code)");
        String storedCellphoneNum= scanner.nextLine();
        checkCellphoneNum(storedCellphoneNum);


        String registerStatus = registerUser(storedUsername, storedPassword);
        System.out.println(registerStatus);
        System.out.println();
       
        if(registerStatus.equals("SUCCESFULLY REGISTERED")){
            
            System.out.println("***REGISTRATION SUCCESFUL***");
            System.out.println("***YOU MAY LOGIN***");
            System.out.println();
        
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
        
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            
            System.out.println(returnLoginStatus(username, storedUsername, password, storedPassword));
        }
        scanner.close();
    }
    
    public String registerUser(String username, String password){
        if(checkUsername(username) && checkPassword(password)){
            return "SUCCESFULLY REGISTERED";
        }
        else if(!checkUsername(username) && checkPassword(password)){
            return "REGISTRATION FAILD  Username is not correctly formated please ensure it contains an underscore and is no more than five characters in lenght";
        }
        else if(checkUsername(username) && !checkPassword(password)){
            return "REGISTRATION FAILD  Password is not correctly formated, Please ensure it is atleast 8 characters, "
                    + "contain atleast one number, one Capital letter and one special character: ";
        }
        else{
            return "REGISTRATION FAILD  Both username and password are incorrect ";
        }
    }

    public boolean loginUser(String username, String storedUsername, String password, String storedPassword){
        
        return storedUsername.equals(username)  
                && storedPassword.equals(password);
        
    }
    
    public String returnLoginStatus(String username, String storedUsername, String password, String storedPassword){
        
        if(loginUser(username, storedUsername, password, storedPassword)){
        return "Welcome " + username + " it is great to see you again.";
        }
        else{
             return "Password or username incorrect please try again.";
        }
        
    }
    
    public boolean checkUsername(String username){
        if (username.contains("_") && username.length() <= 5){
            System.out.println("Username succesfully captured");
            return true;
        }
        else{
            System.out.println("Username is not correctly formated please ensure it contains an underscore and is no more than five characters in lenght");
            return false;
        }
    }
    
    public boolean checkPassword(String password){
        if(password.length() >=8 &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[!@#$%&?/*^~`].*")){
            
            System.out.println("Password succesfully captured");
            return true;
        }
        else{
            System.out.println("Password is not correctly formated, Please ensure it is atleast 8 characters, "
                    + "contain atleast one number, one Capital letter and one special character: ");
            return false;
        }
    }
    
    public boolean checkCellphoneNum(String cellPhoneNumber){
        if(cellPhoneNumber.matches("^\\+27\\d{9}$")){
            System.out.println("Cellphone number succesfully captured");
            return true;
        }
        else{
            System.out.println("Cellphone number incorrectly formated or does not contain international code");
            return false;
        }
    }
}

