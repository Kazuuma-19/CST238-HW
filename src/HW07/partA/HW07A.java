/*
 * Title: HW07A.java
 * Abstract: This program generate a string of folded numbers using file input.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 1.5h
 * Date: 10/23/2023
 */
package HW07.partA;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HW07A {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();

        // load file
        int[] num = loadNumbers(filename);
        // sort number by ascending
        sort(num);
        // format
        String formatNum = foldNumbers(num);
        System.out.println(formatNum);
    }

    static int[] loadNumbers(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        Scanner sc = new Scanner(fr);
        int size = sc.nextInt();

        int[] num = new int[size];

        for (int i = 0; i < size; i++) {
            num[i] = sc.nextInt();
        }

        return num;
    }

    static void sort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int comp = i;
            while (comp > 0 && num[comp] < num[comp - 1]) {
                swap(num, comp, comp - 1);
                comp--;
            }
        }
    }

    static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    static String foldNumbers(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            int start = a[i];
            int end = start;

            // Find the end of the sequence number
            while (i + 1 < a.length && (a[i + 1] == end || a[i + 1] == end + 1)) {
                end = a[i + 1];
                i++;
            }

            if (start != end) {
                sb.append(start).append("-").append(end).append(" ");
            } else {
                sb.append(start).append(" ");
            }
        }
        return sb.toString();
    }
}
