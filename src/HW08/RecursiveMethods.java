/*
 * Title: RecursiveMethods.java
 * Abstract: This program uses recursion to perform prime factorization.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 2h
 * Date: 10/31/2023
 */
package HW08;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursiveMethods {
    public static void main(String[] args) {
        int[] data = {1, 4, 9, 12, -13, 46, 12, 17, -3, -9, -12};
        System.out.println("Count of odds (should be 6): " + countOdds(data, data.length));
        System.out.println("Sum of odds (should be 2): " + sumOdds(data, data.length));

        System.out.print("Printing odds forward (should be 1 9 -13 17 -3 -9):  ");
        printOddsForward(data, 0);
        System.out.println();

        System.out.print("Printing odds backward (should be -9 -3 17 -13 9 1): ");
        printOddsBackward(data, data.length);
        System.out.println();

        ArrayList<Integer> dataList = fromArray(data);
        System.out.println("Sum of ArrayList (should be 64): " + sumArrayList(dataList));

        Scanner in = new Scanner(System.in);
        promptPrimes(in, 2);
    }

    public static void promptPrimes(Scanner in, int value) {
        if (value == 0) {
            return;
        } else {
            System.out.printf("Is %d prime? %b\n", value, isPrime(value));
            ArrayList<Integer> factors = factorNumber(value);
            printFactors(factors);
            System.out.print("Enter a number (0 to quit): ");
            int input = in.nextInt();
            promptPrimes(in, input);
        }
    }

    public static ArrayList<Integer> fromArray(int[] source) {
        ArrayList<Integer> dest = new ArrayList<>();
        fromArray(dest, source, 0);
        return dest;
    }

    public static void fromArray(ArrayList<Integer> dest, int[] source, int start) {
        if (start >= source.length) {
            return;
        } else {
            dest.add(source[start]);
            fromArray(dest, source, start + 1);
        }
    }

    public static int sumArrayList(ArrayList<Integer> list) {
        return sumArrayList(list, 0);
    }

    public static int sumArrayList(ArrayList<Integer> list, int position) {
        if (position >= list.size()) {
            return 0;
        } else {
            return list.get(position) + sumArrayList(list, position + 1);
        }
    }

    public static boolean isPrime(int base) {
        if (base < 4) {
            return true;
        } else {
            return isPrime(base, 2);
        }
    }

    public static boolean isPrime(int base, int comparison) {
        if (comparison >= base || base < 2) {
            return false;
        }
        if (base % comparison == 0) {
            return true;
        }
        return isPrime(base, comparison + 1);
    }

    public static void printFactors(ArrayList<Integer> factors) {
        System.out.println("= " + printFactors(factors, 0));
    }

    public static int printFactors(ArrayList<Integer> factors, int start) {
        if (start >= factors.size()) {
            return 1;
        }
        System.out.print(factors.get(start) + " ");
        // not last element
        if (start < factors.size() - 1) {
            System.out.print("* ");
        }
        return factors.get(start) * printFactors(factors, start + 1);
    }

    public static ArrayList<Integer> factorNumber(int base) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        factorNumber(al, base, 2);
        return al;
    }

    public static void factorNumber(ArrayList<Integer> factors, int base, int comparison) {
        if (base <= 1) {
            return;
        }
        if (base % comparison == 0) {
            factors.add(comparison);
            factorNumber(factors, base / comparison, comparison);
        } else {
            factorNumber(factors, base, comparison + 1);
        }
    }

    public static int countOdds(int[] a, int size) {
        if (size <= 0 || size > a.length) {
            return 0;
        }
        int count = 0;
        // if odd
        if (a[size - 1] % 2 != 0) {
            count = 1;
        }
        return countOdds(a, size - 1) + count;
    }

    public static int sumOdds(int[] a, int size) {
        if (size <= 0 || size > a.length) {
            return 0;
        }
        int sum = 0;
        if (a[size - 1] % 2 != 0) {
            sum = a[size - 1];
        }
        return sumOdds(a, size - 1) + sum;
    }

    public static void printOddsForward(int[] a, int start) {
        if (start >= a.length - 1) {
            return;
        }
        if (a[start] % 2 != 0) {
            System.out.print(a[start] + " ");
        }
        printOddsForward(a, start + 1);
    }

    public static void printOddsBackward(int[] a, int size) {
        if (size <= 0 || size > a.length) {
            return;
        }
        if (a[size - 1] % 2 != 0) {
            System.out.print(a[size - 1] + " ");
        }
        printOddsBackward(a, size - 1);
    }
}
