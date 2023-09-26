/*
 * Title: Queue.java
 * Abstract: This program extends lab solution and adds 4 methods.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 2.5h
 * Date: 09/25/2023
 */
package HW04.partB;

public class Queue {
    public static final int QUEUE_CAPACITY = 7;
    private char[] data;
    private int front;
    private int back;

    public Queue() {
        data = new char[QUEUE_CAPACITY];
        front = 0;
        back = 0;
    }

    public boolean isEmpty() {
        return front == back;
    }

    public void enqueue(char value) {
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

    public int find(int value) {
        boolean found = false;
        int pos = 1;
        for (int i = front; i != back; i = (i + 1) % data.length) {
            if (data[i] == value) {
                found = true;
                break;
            } else {
                pos++;
            }
        }

        if (!found) {
            return -1;
        } else {
            return pos;
        }

    }

    public int freeSpace() {
        if (isEmpty()) {
            return data.length - 1;
        } else if (front < back) {
            return data.length - (back - front) - 1;
        } else {
            return front - back - 1;
        }
    }

    public void rearrange() {
        char[] d2 = new char[data.length];
        for (int i = 0, k = front; k != back; i++, k++) {
            d2[i] = data[k];
        }
        data = d2;
    }

    /********
     homework
     *********/
    public boolean isSorted() {
        boolean isAscending = true;
        boolean isDescending = true;

        // empty
        if (isEmpty()) {
            return true;
        }

        for (int i = front; i != back; i = (i + 1) % data.length) {
            int nextIndex = (i + 1) % data.length;

            if (nextIndex == back) {
                break;
            }

            if (data[i] > data[nextIndex]) {
                isAscending = false;
            }
            if (data[i] < data[nextIndex]) {
                isDescending = false;
            }
        }

        return isAscending || isDescending;
    }

    public boolean drop(char value) {
        boolean canDrop = false;
        int dropIndex = 0;

        // check if there is the value
        for (int i = front; i != back; i = (i + 1) % data.length) {
            if (data[i] == value) {
                dropIndex = i;
                canDrop = true;
                break;
            }
        }

        // left-shift
        if (canDrop) {
            for (int i = dropIndex; i != back; i = (i + 1) % data.length) {
                data[i] = data[(i + 1) % data.length];
            }
            back = (back - 1) % data.length;
        }
        return canDrop;
    }

    public boolean indexUsed(int index) {
        if (index >= 0 && index < QUEUE_CAPACITY) {
            for (int i = front; i != back; i = (i + 1) % data.length) {
                if (index == i) {
                    return true;
                }
            }
        }

        return false;
    }

    public void dump() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            if (indexUsed(i)) {
                sb.append(data[i] + " ");
            } else {
                sb.append("_ ");
            }
        }
        System.out.println("front: " + front);
        System.out.println("back: " + back);
        System.out.println(sb.toString());
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Queue Contents: ");
        if (isEmpty()) {
            sb.append("Empty");
        } else {
            for (int i = front; i != back; i = (i + 1) % data.length) {
                sb.append(data[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}