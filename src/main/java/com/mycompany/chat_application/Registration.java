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
        if (checkUsername(storedUsername)){
            System.out.println("Username succesfully captured");
        }
        else{
            System.out.println("Username is not correctly formated");
            return;
        }
        System.out.println("Enter password (MUST be atleast 8 characters, contain atleast one number, one Capital letter and one special character: ");
        String storedPassword = scanner.nextLine();

        System.out.println("Enter your cellphone number(MUST contain national code(+27) and be ten digits(9 excluding the code)");
        String storedCellphoneNum= scanner.nextLine();
        if (checkCellphoneNum(storedCellphoneNum)){
            System.out.println("Cellphone succesfully captured");
        }
        else{
            System.out.println("Cellphone number incorrectly formated or does not contain international code");
            return;
        }
        
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
            return "Username is not correctly formated please ensure it contains an underscore and is no more than five characters in lenght";
        }
        else if(checkUsername(username) && !checkPassword(password)){
            return "Password is not correctly formated, Please ensure it is atleast 8 characters, "
                    + "contain atleast one number, one Capital letter and one special character: ";
        }
        else{
            return "Both username and password are incorrect REGISTRATION FAILD";
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
        return username.contains("_") && username.length() <=5;
    }
    
    public boolean checkPassword(String password){
        return password.length() >=8 &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[!@#$%&?/*^~`].*");
    }
    
    public boolean checkCellphoneNum(String cellPhoneNumber){
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }
}

