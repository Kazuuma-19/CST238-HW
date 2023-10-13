/*
 * Title: Queue.java
 * Abstract: This program resize queue.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 2h
 * Date: 10/12/2023
 */
package HW05.partB;

public class Queue {
    public static final int QUEUE_CAPACITY = 6;
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
//            System.out.println("**Queue full - cannot enqueue " + value + "**");
//            return;
            resize();
            newBack = (back + 1) % data.length;
        }
        data[back] = value;
        back = newBack;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("**Queue empty - cannot dequeue**");
            return;
        }
        data[front] = 0;
        front = (front + 1) % data.length;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("**Queue empty - returning garbage value**");
            return 0;
        }
        return data[front];
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public int getSize() {
        if (front > back) {
            return (data.length - front) + back;
        } else {
            return back - front;
        }
    }

    public void resize() {
        int[] temp = new int[data.length + 6];
        for (int i = 0; i < data.length; i++) {
            if (i < back) {
                temp[i] = data[i];
            } else {
                temp[i + 6] = data[i];
            }
        }

        data = temp;
        front = front + 6;

        System.out.println("Array is resized");
        System.out.println();
    }

    public String printable() {
        StringBuffer sb = new StringBuffer();
        sb.append("(f: " + front + ", ");
        sb.append("b: " + back + ") ");
        sb.append("Contents: ");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]).append(" ");
        }
        return sb.toString();
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
