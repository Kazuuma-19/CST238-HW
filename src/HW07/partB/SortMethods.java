/*
 * Title: SortMethods.java
 * Abstract: This program compares each sorting. I also created a fastInsertionSort as an extra credit.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 2.5h
 * Date: 10/26/2023
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
                comparisons++;
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                    swaps++;
                }
            }
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
            while (comp > 0) {
                comparisons++;

                if (data[comp] < data[comp - 1]) {
                    swap(data, comp, comp - 1);
                    comp--;
                    swaps++;
                } else {
                    break;
                }
            }
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
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j = i - 1;

            while (j >= 0) {
                comparisons++;

                if (data[j] > temp) {
                    shift(data, j, j + 1);
                    j = j - 1;
                    swaps++;
                } else {
                    break;
                }
            }

            data[j + 1] = temp;
        }

        sw.stop();
        return new SortResults("Fast Insertion", isSorted(data), sw.elapsed(TimeUnit.MICROSECONDS), swaps / 3, comparisons);
    }

    public static void shift(int[] data, int fromIndex, int toIndex) {
        data[toIndex] = data[fromIndex];
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
