/*
 * Title: HW03a_Student.java
 * Abstract: This program is a list with various functions.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 1h
 * Date: 09/13/2023
 */
public class HW03c_Advance {
    public static void main(String[] args) {
        List myList = new List();
        myList.append(10);
        myList.append(20);
        myList.append(20);
        myList.append(30);

        System.out.println();

        myList.display();

        System.out.println("size of the list: " + myList.getSize());
        System.out.println("value: " + myList.get(0));
        System.out.println("hasDuplicate: " + myList.hasDuplicates());
        System.out.println("isSorted: " + myList.isSorted());
    }
}

class List {
    private static int DEFAULT_CAPACITY = 10;
    private int size;
    private int[] data;

    public List() {
        size = 0;
        data = new int[DEFAULT_CAPACITY];
    }

    public List(int capacity) {
        size = 0;
        data = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int item, int position) {
        if (size == data.length) {
            System.out.println("** No space for list element **");
            return;
        }

        if (position < 0 || position > size) {
            System.out.println("** Illegal location to insert " + position + " **");
            return;
        }

        // right shift
        for (int i = size; i > position; i--) {
            data[i] = data[i - 1];
        }

        data[position] = item;
        size++;
    }

    public void remove(int position) {
        if (isEmpty()) {
            System.out.println("** Empty list - cannot remove **");
            return;
        }

        if (position < 0 || position >= size) {
            System.out.println("** Illegal location to remove " + position + " **");
            return;
        }

        for (int i = position; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        } else {
            System.out.print("List of size " + size + ": ");
        }

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i];
        }
        return sum;
    }

    public boolean append(int value) {
        if (size == data.length) {
            System.out.println("** No room left to append **");
            return false;
        } else {
            data[size] = value;
            size++;
            return true;
        }
    }

    /********

     homework
     *********/
    public int getSize() {
        return size;
    }

    public int get(int pos) {
        if (pos >= 0 && pos < size) {
            return data[pos];
        } else {
            return -1;
        }
    }

    public boolean hasDuplicates() {
        boolean hasDupilicate = false;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (data[i] == data[j]) {
                    hasDupilicate = true;
                }
            }
        }

        return hasDupilicate;
    }

    public boolean isSorted() {
        boolean isAscending = false;
        boolean isDescending = false;
        boolean isSameNumber = false;

        // empty
        if (isEmpty()) {
            return true;
        }

        // same number
        for (int i = 1; i < size; i++) {
            if (data[i] == data[i - 1]) {
                isSameNumber = true;
            } else {
                break;
            }
        }

        // ascending
        for (int i = 1; i < size; i++) {
            if (data[i] == data[i - 1]) {
                isSameNumber = true;
            }

            if (data[i - 1] <= data[i]) {
                isAscending = true;
            } else {
                isAscending = false;
                break;
            }
        }

        // descending
        for (int i = 1; i < size; i++) {
            if (data[i - 1] >= data[i]) {
                isDescending = true;
            } else {
                isDescending = false;
                break;
            }
        }

        return isSameNumber || isAscending || isDescending;
    }
}