package com.demo.test;
//Question no.2
class QNode {
    int data;
    QNode next;

    QNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularQueue {
    QNode front = null, rear = null;

    void enqueue(int data) {
        QNode newNode = new QNode(data);
        if (front == null) {
            front = rear = newNode;
            rear.next = front;
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
    }

    void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }

        if (front == rear) {
            System.out.println("Deleted: " + front.data);
            front = rear = null;
        } else {
            System.out.println("Deleted: " + front.data);
            front = front.next;
            rear.next = front;
        }
    }

    void display() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }

        QNode temp = front;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.display();
    }
}
