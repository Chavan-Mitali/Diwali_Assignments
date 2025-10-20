package com.demo.test;
//Question no.1

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    Node head = null;

    void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (head == null) {  
            head = newNode;
            head.next = head;
            return;
        }

        if (position == 1) {  
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current.next != head; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    void deleteNode(int key) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head, prev = null;

        if (head.data == key) {
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;
            if (head.next == head) {  
                head = null;
                return;
            }
            temp.next = head.next;
            head = head.next;
            return;
        }

        do {
            prev = current;
            current = current.next;
        } while (current != head && current.data != key);

        if (current.data == key) {
            prev.next = current.next;
        } else {
            System.out.println("Node not found!");
        }
    }

    void modifyNode(int oldData, int newData) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        do {
            if (temp.data == oldData) {
                temp.data = newData;
                System.out.println("Data modified successfully.");
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Data not found!");
    }

    // d) Display list
    void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        while (true) {
            System.out.println("\n1.Insert  2.Delete  3.Modify  4.Display  5.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    list.insertAtPosition(data, pos);
                    break;

                case 2:
                    System.out.print("Enter data to delete: ");
                    int del = sc.nextInt();
                    list.deleteNode(del);
                    break;

                case 3:
                    System.out.print("Enter old data: ");
                    int oldData = sc.nextInt();
                    System.out.print("Enter new data: ");
                    int newData = sc.nextInt();
                    list.modifyNode(oldData, newData);
                    break;

                case 4:
                    list.display();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}

