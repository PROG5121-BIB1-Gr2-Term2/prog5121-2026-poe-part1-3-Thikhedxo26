/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package loginsystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author thikhedzo
 */



public class LoginSystemTest {

 LoginSystem login=new LoginSystem();   

    public LoginSystemTest() {
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
    
 // Test correct username
    @Test
    public void testUserNameCorrect() {
        boolean result = login.checkUserName("kyl_1");
        assertTrue(result);
    }

    // Test incorrect username
    @Test
    public void testUserNameIncorrect() {
        boolean result = login.checkUserName("kyle!!!!");
        assertFalse(result);
    }

    // Test correct cellphone
    @Test
    public void testCellPhoneCorrect() {
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertTrue(result);
    }

    // Test incorrect cellphone
    @Test
    public void testCellPhoneIncorrect() {
        boolean result = login.checkCellPhoneNumber("08966553");
        assertFalse(result);
    }

    // Test successful login
    @Test
    public void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        boolean result = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(result);
    }

    // Test failed login
    @Test
    public void testLoginFailed() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        boolean result = login.loginUser("wrongUser", "wrongPass");
        assertFalse(result);
    }
}

   