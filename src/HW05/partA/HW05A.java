/*
 * Title: HW05A.java
 * Abstract: This program merges two array in ascending order.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 1h
 * Date: 10/09/2023
 */
package HW05.partA;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HW05A {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first filename: ");
        String f1 = sc.nextLine();
        int[] firstArray = loadArray(f1);

        System.out.print("Enter first filename: ");
        String f2 = sc.nextLine();
        int[] secondArray = loadArray(f2);

        int[] mergedArray = mergeSorted(firstArray, secondArray);
        StringBuffer sb = new StringBuffer("Combined array: ");

        for (int el : mergedArray) {
            sb.append(el).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static int[] loadArray(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        Scanner sc = new Scanner(fr);
        int arraySize = sc.nextInt();
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = sc.nextInt();
        }

        return array;
    }

    public static int[] mergeSorted(int[] a, int[] b) {
        int arraySize = a.length + b.length;
        int[] mergedArray = new int[arraySize];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                mergedArray[k++] = a[i++];
            } else {
                mergedArray[k++] = b[j++];
            }
        }

        while (i < a.length) {
            mergedArray[k++] = a[i++];
        }
        while (j < b.length) {
            mergedArray[k++] = b[j++];
        }

        return mergedArray;
    }
}
