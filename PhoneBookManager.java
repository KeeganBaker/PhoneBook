// File Name: PhoneBookManager.java
// Date Edited: 02/14/2024
// Name: Keegan Baker
// Project: CS 145 Assignment 2
// Purpose: This class will manage a linked list to store data of the phone book
//////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class PhoneBookManager {
    
    Node head; // current first node in the list
    Scanner sc = new Scanner(System.in); // to get user input


    // Method checks first char for a number
    public boolean charCheck(String a) {
        
        boolean check = true;
        char b = a.charAt(0);

        switch (b) {
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            return check; // it's a number
        default:
            check = false; // it's not a number
            return check; 
        }

        
    }



    // Method to find a contact based on name or number
    public Node find(String a) {

        Node found = this.head;

        try {
            if (charCheck(a)) { // Based off of contactNumber
                int b = a.charAt(0) - 48;
                while (b != found.contactNumber) {
                    found = found.next;
                }
                return found;
            }
            // Based off of name
            while (!a.equals(found.name)) {
                found = found.next;
            }
            return found;
            
        }
        catch (Exception e) {
            System.out.println("Contact not found...");
            found = null;
            return found;
        }
    }



    // Adjusts numbers in the list
    public void adjustIndex() {
        
        if (this.head == null) { // nothing to adjust
            return;
        }

        int a = 1;
        Node current = this.head;

        while (true) {
            current.contactNumber = a;
            a++;
            if (current.next == null) {
                return;
            }
            current = current.next;
        } 
    }



    // Method inserts a new node into the front of the list
    public void add() {

        System.out.print("Contact name: ");
        String name = sc.nextLine();
        
        System.out.print("Address: ");
        String address = sc.nextLine();

        System.out.print("City: ");
        String city = sc.nextLine();

        System.out.print("Phone number: ");
        String phoneNumber = sc.nextLine();

        Node newNode = new Node(name, address, city, phoneNumber);
        newNode.next = this.head; // newNode points to head as it's next node
        this.head = newNode; // head changed to the newly created node
        adjustIndex(); // order all contact numbers
    }



    // Method deletes a given contact (node)
    public void delete() {
        
        if (this.head == null) { // message if book is empty
            System.out.println("***  !! Phone book is empty !!  ***");
            System.out.println("*** please create a new contact ***");
            return;
        }

        System.out.print("Enter contact number or name: ");
        String a = sc.nextLine();
        Node deletedNode = find(a);

        if (deletedNode == null) { // contact not found
            return;
        }
        
        // first node is selected
        if (this.head == deletedNode){
            this.head = head.next;
            adjustIndex();
            return;
        }

        // node somewhere after head is selected
        Node current = this.head;
        while (current.next != deletedNode) {
            current = current.next;
        }

        // Set the new link and delete the old node
        current.next = current.next.next;
        adjustIndex();
    }


    
    // Searches for a node with given criteria
    public Node search() {

        String find;
        Node found = this.head;
        System.out.println("\n==============================");
            System.out.println("\t1 - Contact #");
            System.out.println("\t2 - Name");
            System.out.println("\t3 - Address");
            System.out.println("\t4 - Phone number");
            System.out.println("==============================");
        System.out.print("Search based on: ");
        String commandString = sc.nextLine();

        try {
            // execute based on user input
            char command = commandString.charAt(0);
            switch (command) {
                case '1':
                case 'C':
                case 'c':
                    System.out.print("Contact #: ");
                    int num = sc.nextInt();
                    while (num != found.contactNumber) {
                        found = found.next;
                    }
                    return found;

                case '2':
                case 'N':
                case 'n':
                    System.out.print("Contact name: ");
                    find = sc.nextLine();
                    while (!find.equals(found.name)) {
                        found = found.next;
                    }
                    return found;

                case '3':
                case 'A':
                case 'a':
                    System.out.print("Contact address: ");
                    find = sc.nextLine();
                    while (!find.equals(found.address)) {
                        found = found.next;
                    }
                    return found;

                case '4':
                case 'P':
                case 'p':
                System.out.print("Contact phone number: ");
                find = sc.nextLine();
                while (!find.equals(found.phoneNumber)) {
                    found = found.next;
                }
                return found;

                default: 
                System.out.println("!! Invalid command !!");
                found = null;
                return found;
            }
        } 
        catch (Exception e) { 
            // WOMP WOMP
        }
        System.out.println("Contact not found..."); // error message
        found = null;
        return found;
    }



    // Displayes given node
    public void display() {

        if (this.head == null) { // message if book is empty
            System.out.println("***  !! Phone book is empty !!  ***");
            System.out.println("*** please create a new contact ***");
            return;
        }

        Node current = search(); // find the desired contact

        if (current == null) { // no contact found
            return;
        }

        System.out.println( // display
          "*************************************************");
            System.out.println("Contact #" + current.contactNumber + " - " + current.name);
            System.out.println(current.address + ", " + current.city);
            System.out.println(current.phoneNumber);
            System.out.println(
          "*************************************************");
    }



    // edit a given contact's information
    public void edit() {

        if (this.head == null) { // message if book is empty
            System.out.println("***  !! Phone book is empty !!  ***");
            System.out.println("*** please create a new contact ***");
            return;
        }

        // find the contact to edit
        System.out.print("Enter contact number or name: ");
        String lookingFor = sc.nextLine();
        Node current = find(lookingFor);
        if (current == null) {
            return;
        }


        // User selects which field they want to edit
        System.out.println("\n==============================");
        System.out.println("\t1 - Name");
        System.out.println("\t2 - Address");
        System.out.println("\t3 - Phone number");
        System.out.println("==============================");
        System.out.print("Choose a field to edit: ");
        
        String commandString = sc.nextLine();
        char command = commandString.charAt(0);
        String change;

        switch (command) {
        case '1':
        case 'N':
        case 'n':
            // change name
            System.out.println("Current name: " + current.name);
            System.out.print("New contact name: ");
            change = sc.nextLine();
            current.name = change;
        return;

        case '2':
        case 'A':
        case 'a':
            // change address
            System.out.println("Current address: " + current.address);
            System.out.print("New contact address: ");
            change = sc.nextLine();
            current.address = change;
        return;

        case '3':
        case 'P':
        case 'p':
            // change phone number
            System.out.println("Current phone number: " + current.phoneNumber);
            System.out.print("New contact phone number: ");
            change = sc.nextLine();
            current.phoneNumber = change;
        return;

        default: 
            System.out.println("Invalid command! Returning to main menu...");
        return;
        }
    }



    // method displays the entire phone book
    public void view() {

        Node current = this.head; // copy list so head isn't lost

        if (current == null) { // message if book is empty
            System.out.println("***  !! Phone book is empty !!  ***");
            System.out.println("*** please create a new contact ***");
            return;
        }
        while (true) {
            System.out.println("Contact #" + current.contactNumber + " - " + current.name);
            System.out.println(current.address + ", " + current.city);
            System.out.println(current.phoneNumber);
            System.out.println(
          "*************************************************");
            if (current.next == null) {
                return;
            }
            current = current.next;
        } 
    }
}
