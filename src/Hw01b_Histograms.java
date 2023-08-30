/*
 * Title: Hw01b_Histograms.java
 * Abstract: This program print a Horizontal and Vertical Histogram
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 1.5h
 * Date: 8/29/2023
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Hw01b_Histograms {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input file name: ");
        String fileName = scanner.nextLine();

        FileReader fr = new FileReader(fileName);
        Scanner fs = new Scanner(fr);

        int size = fs.nextInt();
        int[] inputs = new int[size];

        for (int i = 0; i < size; i++) {
            inputs[i] = fs.nextInt();
        }

        fr.close();

        horizontal(inputs);
        vertical(inputs);
    }


    // horizontal
    public static void horizontal(int[] inputs) {
        System.out.println("===== Horizontal Histogram =====");

        for (int i = 0; i < inputs.length; i++) {
            System.out.print(inputs[i] + ": ");
            for (int j = 0; j < inputs[i]; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
    }

    // vertical
    public static void vertical(int[] inputs) {
        System.out.println("=====  Vertical Histogram  =====");

        // find maxNum
        int maxNum = inputs[0];

        for (int input : inputs) {
            if (maxNum < input) {
                maxNum = input;
            }
        }

        for (int i = maxNum; i >= 1; i--) {
            for (int j = 0; j < inputs.length; j++) {
                if (inputs[j] >= i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println("----------");

        for (int input : inputs) {
            System.out.print(input + " ");
        }
    }
}
