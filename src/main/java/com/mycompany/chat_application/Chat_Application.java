/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chat_application;


/**
 *
 * @author Student
 */
public class Chat_Application {

    public static void main(String[] args) {
        Registration reg = new Registration();
        Message message = new Message();

        
        //if statement so the user can only message if he was able to login succesfully
        if (reg.register()){
            message.Messaging();
        }
    }
}


    

