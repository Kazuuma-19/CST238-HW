package HW07.partB;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter PRNG seed: ");
        int seed = in.nextInt();
        prime(generateNumbers(10000, seed + 1, false));
        prime(generateNumbers(10000, seed + 1, false));
        while (true) {
            System.out.print("Enter size (0 to quit): ");
            int size = in.nextInt();
            if (size == 0) break;
            System.out.print("Presorted (y/n)? ");
            boolean sorted = in.next().matches("[yY].*");

            int[] a = generateNumbers(size, seed, sorted);
            int[] b = Arrays.copyOf(a, a.length);
            int[] c = Arrays.copyOf(a, a.length);
            int[] d = Arrays.copyOf(a, a.length);
            System.out.printf("%-20s %8s %14s %12s %12s\n", "Sorting Algorithm", "Sorted", "Microseconds", "Swaps", "Comparisons");

            System.out.println(SortMethods.bubbleSort(a, true));

            System.out.println(SortMethods.selectionSort(b, true));

            System.out.println(SortMethods.insertionSort(c, true));

            System.out.println(SortMethods.fastInsertionSort(d, true));

            System.out.println();
        }

    }

    public static void prime(int[] data) {
        int[] a = Arrays.copyOf(data, data.length);
        int[] b = Arrays.copyOf(data, data.length);
        int[] c = Arrays.copyOf(data, data.length);
        int[] d = Arrays.copyOf(data, data.length);
        SortResults sr1 = SortMethods.bubbleSort(a, true);
        SortResults sr2 = SortMethods.selectionSort(b, true);
        SortResults sr3 = SortMethods.insertionSort(c, true);
        SortResults sr4 = SortMethods.fastInsertionSort(d, true);
    }

    public static int[] generateNumbers(int size, int seed, boolean sorted) {
        Random r = new Random(seed);
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(size * 2);
            if (r.nextBoolean()) {
                data[i] *= -1;
            }
        }
        if (sorted) Arrays.sort(data);
        return data;
    }

}
