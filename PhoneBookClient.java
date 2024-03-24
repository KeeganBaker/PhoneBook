// File Name: PhoneBookClient.java
// Date Edited: 02/14/2024
// Name: Keegan Baker
// Project: CS 145 Assignment 2
// Purpose: This program will create a phone book that can be modified and displayed 
//          by the user.
//////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class PhoneBookClient {
    public static void main(String[] args) {
        
        PhoneBookManager phoneBook = new PhoneBookManager();
        Scanner sc = new Scanner(System.in);
        char command = 0;

        do {
            // command list
            System.out.println("\n==============================");
            System.out.println("\t1 - Add");
            System.out.println("\t2 - Delete");
            System.out.println("\t3 - Search");
            System.out.println("\t4 - Edit");
            System.out.println("\t5 - View all");
            System.out.println("\t0 - Quit");
            System.out.println("==============================");
            System.out.print("Enter a command: ");

            //user input
            String commandString = sc.next();
            command = commandString.charAt(0);
            switch (command) {
            case '1':
            case 'A':
            case 'a':
                // Add contact
                phoneBook.add();
            break;

            case '2':
            case 'D':
            case 'd':
                // Delete contact
                phoneBook.delete();
            break;

            case '3':
            case 'S':
            case 's':
                // Search/display
                phoneBook.display();
            break;

            case '4':
            case 'E':
            case 'e':
                // Edit
                phoneBook.edit();
            break;

            case '5':
            case 'V':
            case 'v':
                // Print phoneBook
                System.out.println(
                "\n************************" + 
                "*************************");
                phoneBook.view();
            break;

            case '0':
            case 'Q':
            case 'q':
                // quit the program
                System.out.println("Goodbye!\n");
            break;

            // Case for tests 
            // case 't':
            //     
            // break;

            default: 
                System.out.println("!! INVALID COMMAND -- TRY AGAIN !!");
            }
        } while (command != '0' && command != 'q' && command != 'Q');
        sc.close();
    }
}
