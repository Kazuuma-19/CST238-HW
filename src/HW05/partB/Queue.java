/*
 * Title: Queue.java
 * Abstract: This program convert decimal to binary.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 30m
 * Date: 09/23/2023
 */
package HW05.partB;

public class Queue {
    public static final int QUEUE_CAPACITY = 10;
    private int[] data;
    private int front;
    private int back;

    public Queue() {
        data = new int[QUEUE_CAPACITY];
        front = 0;
        back = 0;
    }

    public boolean isEmpty() {
        return front == back;
    }

    public void enqueue(int value) {
        int newBack = (back + 1) % data.length;
        if (newBack == front) {
            System.out.println("**Queue full - cannot enqueue " + value + "**");
            return;
        }
        data[back] = value;
        back = newBack;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("**Queue empty - cannot dequeue**");
            return;
        }
        // data[front] = null; // only if stack contains objects
        front = (front + 1) % data.length;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("**Queue empty - returning garbage value**");
            return 0;
        }
        return data[front];
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Queue Contents: ");
        if (isEmpty()) {
            sb.append("Empty");
        } else {
            for (int i = front; i != back; i = (i + 1) % data.length) {
                sb.append(data[i] + " ");
            }
        }
        return sb.toString();
    }
}
