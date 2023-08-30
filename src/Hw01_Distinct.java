/*
 * Title: Hw01_Distinct.java
 * Abstract: This program is counting distinct numbers.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 1.5 hours
 * Date: 8/29/2023
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Hw01_Distinct {
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

        findMinNum(inputs);
        countNum(inputs, size);
    }

    public static void findMinNum(int[] inputs) {
        // find minNum
        int minNum = inputs[0];

        for (int input : inputs) {
            if (input < minNum) {
                minNum = input;
            }
        }

        System.out.println("MinNumber: " + minNum);
    }

    public static void countNum(int[] inputs, int size) {
        System.out.println("Number Count");

        for (int i = 0; i < size; i++) {
            boolean alreadyCounted = false;

            // check whether the num already exists
            for (int k = 0; k < i; k++) {
                if (inputs[i] == inputs[k]) {
                    alreadyCounted = true;
                }
            }

            // count number
            if (!alreadyCounted) {
                int count = 1;
                for (int j = i + 1; j < size; j++) {
                    if (inputs[i] == inputs[j]) {
                        count++;
                    }
                }
                System.out.println(inputs[i] + " " + count);
            }
        }
    }
}