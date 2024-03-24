 // File Name: Node.java
// Date Edited: 02/15/2024
// Name: Keegan Baker
// Project: CS 145 Assignment 2
// Purpose: This class holds data and a pointer to the next element in a linked list.
//////////////////////////////////////////////////////////////////////////////////////////////////
 
 public class Node {
    
    // Data stored in the node
    int contactNumber;
    String name;
    String address;
    String city;
    String phoneNumber;

    Node next; // Reference to the next node in the list

    // Constructor initializes the node with data
    public Node(String name, String address, String city, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }
 }