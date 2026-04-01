/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;


import com.mycompany.chat_application.Registration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class TestChat_Application {
    
    @Test
    public void TestUsernameCorrectlyFormated() {
    Registration register = new Registration();
  
    boolean actual = register.checkUsername("kyl_1");
    boolean expected = true;
    assertEquals(expected, actual);
    }
    
    @Test
    public void TestUsernameInCorrectlyFormated() {
    Registration register = new Registration();
    
    boolean actual = register.checkUsername("kyle!!!!!!");
    boolean expected = false;
    assertEquals(expected, actual);
    }

    @Test
    public void TestLoginSuccesfull(){
        Registration register = new Registration();
        boolean actual = register.loginUser("kyl_1", "kyl_1", "ASDasd!@#123", "ASDasd!@#123");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    
    @Test
    public void TestLoginFailed(){
        Registration register = new Registration();
        boolean actual = register.loginUser("kyl_", "kyl_1", "ASDasd!@#12", "ASDasd!@#123");
        boolean expected = false;
        assertEquals(expected, actual);
    }
    
    @Test
    public void TestpasswordMeetsRequirements() {
    Registration register = new Registration();
  
    boolean actual = register.checkPassword("Ch&&sec@ke99!");
    boolean expected = true;
    assertEquals(expected, actual);
    }
    
    @Test
    public void TestpasswordDoesNotMeetsRequirements() {
    Registration register = new Registration();
  
    boolean actual = register.checkPassword("password");
    boolean expected = false;
    assertEquals(expected, actual);
    }
    
    @Test
    public void TestCellphoneCorrectlyFormated() {
    Registration register = new Registration();
  
    boolean actual = register.checkCellphoneNum("+27838968976");
    boolean expected = true;
    assertEquals(expected, actual);
    }
    
    @Test
    public void TestCellphoneInCorrectlyFormated() {
    Registration register = new Registration();
  
    boolean actual = register.checkCellphoneNum("08966553");
    boolean expected = false;
    assertEquals(expected, actual);
    }
    
    @Test
    public void TestUsernameCorrect(){
    Registration register = new Registration();
    
    String actual = register.returnLoginStatus("kyl_1", "kyl_1", "Ch&&sec@ke99!", "Ch&&sec@ke99!");
    String expected = "Welcome kyl_1 it is great to see you again.";
    assertEquals(expected, actual);
    
    }
    
    @Test
    public void TestUsernameAndPasswordCorrectlyFormated(){
    Registration register = new Registration();
    String actual = register.registerUser("kyl_1", "Ch&&sec@ke99!" );
    String expected = "SUCCESFULLY REGISTERED";
    assertEquals(expected, actual);
    
    }
    
    @Test
    public void TestUsernameIsInCorrectlyFormated(){
    Registration register = new Registration();
    String actual = register.registerUser("kyle!!!!!!", "Ch&&sec@ke99!" );
    String expected = "Username is not correctly formated please ensure it contains "
                    + "an underscore and is no more than five characters in lenght";
    assertEquals(expected, actual);
    
    }
    
    @Test
    public void TestPasswordIsInCorrectlyFormated(){
    Registration register = new Registration();
    String actual = register.registerUser("kyl_1", "password" );
    String expected = "Password is not correctly formated, Please ensure it is atleast 8 characters, "
                    + "contain atleast one number, one Capital letter and one special character: ";
    assertEquals(expected, actual);
    
    }
}
