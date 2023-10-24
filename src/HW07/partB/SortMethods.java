/*
 * Title: SortMethods.java
 * Abstract: This program compares each sorting.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 1.5h
 * Date: 10/24/2023
 */
package HW07.partB;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class SortMethods {

    public static SortResults bubbleSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.println("Starting bubble sort...");
        Stopwatch sw = Stopwatch.createStarted();

        // write sorting code here
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                    swaps++;
                }
            }
            comparisons++;
        }

        sw.stop();
        return new SortResults("Bubble", isSorted(data), sw.elapsed(TimeUnit.MICROSECONDS), swaps, comparisons);
    }

    public static SortResults selectionSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.print("Starting selection sort...");
        Stopwatch sw = Stopwatch.createStarted();

        // write sorting code here
        for (int i = 0; i < data.length - 1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[smallestIndex]) {
                    smallestIndex = j;
                }
                comparisons++;
            }

            if (i != smallestIndex) {
                swap(data, i, smallestIndex);
                swaps++;
            }
        }

        sw.stop();
        return new SortResults("Selection", isSorted(data), sw.elapsed(TimeUnit.MICROSECONDS), swaps, comparisons);
    }

    public static SortResults insertionSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.print("Starting insertion sort...");
        Stopwatch sw = Stopwatch.createStarted();

        // write sorting code here
        for (int i = 1; i < data.length; i++) {
            int comp = i;
            while (comp > 0 && data[comp] < data[comp - 1]) {
                swap(data, comp, comp - 1);
                comp--;
                swaps++;
            }
            comparisons++;
        }

        sw.stop();
        return new SortResults("Insertion", isSorted(data), sw.elapsed(TimeUnit.MICROSECONDS), swaps, comparisons);
    }

    public static SortResults fastInsertionSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.print("Starting fast insertion sort...");
        Stopwatch sw = Stopwatch.createStarted();

        // write sorting code here

        sw.stop();
        return new SortResults("Fast Insertion", isSorted(data), sw.elapsed(TimeUnit.MICROSECONDS), swaps / 3, comparisons);
    }

    public static void shift(int[] data, int fromIndex, int toIndex) {
        // write shift code
    }

    public static void swap(int[] a, int i1, int i2) {
        // write swap code
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }

    public static boolean isSorted(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            // ascending
            if (data[i] > data[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
