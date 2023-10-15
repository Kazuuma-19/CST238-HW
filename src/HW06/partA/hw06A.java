/*
 * Title: HW06A.java
 * Abstract: This program sorts an array based on reading file
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 1h
 * Date: 10/15/2023
 */

package HW06.partA;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class hw06A {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String fileName = scanner.next();

        ArrayList<String> array = readFile(fileName);

        printWords("Words:", array);

        Collections.sort(array);

        printWords("Sorted:", array);
    }

    public static ArrayList<String> readFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        Scanner sc = new Scanner(fr);
        ArrayList<String> array = new ArrayList<>();

        while (sc.hasNext()) {
            String nextString = sc.next();
            array.add(nextString);
        }

        return array;
    }

    public static void printWords(String string, ArrayList<String> array) {
        System.out.println(string);
        for (int i = 0; i < array.size(); i++) {
            System.out.println("\t" + array.get(i));
        }
        System.out.println();
    }
}
