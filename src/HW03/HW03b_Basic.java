package HW03;
/*
 * Title: HW03b_Basic.java
 * Abstract: This program manipulates the list by the user input.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 2h
 * Date: 09/12/2023
 */

import java.util.Scanner;

public class HW03b_Basic {
    public static void main(String[] args) {
        NumberList list = new NumberList();
        System.out.println(list.print());
        System.out.println("This is a list of operations");
        System.out.println("\t" + "0. Exit");
        System.out.println("\t" + "1. Delete the max");
        System.out.println("\t" + "2. Append a number");
        System.out.println("\t" + "3. Reverse array");

        Scanner sc = new Scanner(System.in);

        int option;
        // As long as the option is not 0
        do {
            System.out.print("Enter your option: ");
            option = sc.nextInt();

            // 0
            if (option == 0) {
                System.out.println("Done!");
            }
            // 1 or 2 or 3
            else {
                // 1
                if (option == 1) {
                    list.delete();
                }
                // 2
                else if (option == 2) {
                    // there is space
                    if (list.isSpace()) {
                        System.out.print("Enter the number to append: ");
                        int value = sc.nextInt();
                        list.append(value);
                    } else {
                        System.out.println("List is full, cannot append");
                    }
                }
                // 3
                else if (option == 3) {
                    list.reverse();
                }

                System.out.println(list.print());
            }
        } while (option != 0);

        sc.close();
    }
}

class NumberList {
    private int[] data;
    private int size;

    public NumberList() {
        size = 10;
        data = new int[]{10, 20, 30, 40, 50, 15, 25, 35, 45, 55};
    }

    // print
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("List values (" + size + ")" + ": ");

        for (int i = 0; i < size; i++) {
            sb.append(data[i] + " ");
        }

        return sb.toString();
    }

    // delete max value
    public void delete() {
        // find max
        int maxIndex = 0;

        for (int i = 0; i < size; i++) {
            if (data[maxIndex] < data[i]) {
                maxIndex = i;
            }
        }

        // shift
        for (int i = maxIndex; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    // space
    public boolean isSpace() {
        return data.length != size;
    }

    // append
    public void append(int value) {
        data[size++] = value;
    }

    // reverse
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int temp = data[i];
            data[i] = data[size - i - 1];
            data[size - i - 1] = temp;
        }
    }
}