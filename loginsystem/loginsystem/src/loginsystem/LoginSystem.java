/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginsystem;

/**
 *
 * @author thikhedzo
 */


import java.util.Scanner;

public class LoginSystem {

    String username;
    String password;
    String cellPhone;
    String firstName;
    String lastName;

    public boolean checkUserName(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }


    public boolean checkCellPhoneNumber(String cellPhone) {
        if (cellPhone.startsWith("+27") && cellPhone.length() == 12) {
            return true;
        } else {
            return false;
        }
    }

    public String registerUser(String username, String password, String cellPhone, String firstName, String lastName) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted.";
        }

        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted .";
        }

        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
        this.firstName = firstName;
        this.lastName = lastName;

        return "User registered successfully.";
    }

    public boolean loginUser(String username, String password) {

        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    LoginSystem login = new LoginSystem();

    System.out.println("Register");

    System.out.println("Enter first name:");
    String firstName = input.nextLine();

    System.out.println("Enter last name:");
    String lastName = input.nextLine();

    // USERNAME LOOP
    String username;
    while (true) {
        System.out.println("Enter username:");
        username = input.nextLine();

        if (login.checkUserName(username)) {
            break;
        } else {
            System.out.println("Username is not correctly formatted;please ensure that your username contains an underscore and is no more than five charactersb in length. Try again.");
        }
    }

    // PASSWORD LOOP 
    String password;
    while (true) {
        System.out.println("Enter password:");
        password = input.nextLine();

        if (password.length() >= 8) {   
            break;
        } else {
            System.out.println("Password is not correctly formarted;please ensure that the password contains atleast eight characters;a capital letter;a number and a special character. Try again.");
        }
    }

    // CELLPHONE LOOP
    String cellPhone;
    while (true) {
        System.out.println("Enter phone number (+27):");
        cellPhone = input.nextLine();

        if (login.checkCellPhoneNumber(cellPhone)) {
            break;
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code. Try again.");
        }
    }

    String message = login.registerUser(username, password, cellPhone, firstName, lastName);
    System.out.println(message);

    // LOGIN
    if (message.equals("User registered successfully.")) {

        System.out.println("Login");

        while (true) {

            System.out.println("Enter username:");
            String loginUser = input.nextLine();

            System.out.println("Enter password:");
            String loginPass = input.nextLine();

            if (login.loginUser(loginUser, loginPass)) {
                System.out.println("Welcome " + firstName + " " + lastName + ", it is great to see you again.");
                break;
            } else {
                System.out.println("Username or password incorrect, please try again.");
            }
        }
    }
}
}