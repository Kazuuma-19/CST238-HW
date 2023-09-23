/*
 * Title: Main.java
 * Abstract: This program convert decimal to binary.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 30m
 * Date: 09/23/2023
 */

package HW04.partA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int decimal = 0;
        do {
            System.out.print("Enter a positive number (0 to quit): ");
            decimal = sc.nextInt();

            if (decimal != 0) {
                System.out.println(decimal + " => " + convert(decimal));
            }
        } while (decimal != 0);

        System.out.println("Exiting");
    }

    public static String convert(int number) {
        Stack st = new Stack();

        int remainder;

        while (number != 0) {
            remainder = number % 2;

            if (remainder == 1) {
                st.push(remainder);
            } else if (remainder == 0) {
                st.push(remainder);
            }
            number = number / 2;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(st);

        return sb.toString();
    }
}
