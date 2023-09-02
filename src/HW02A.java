/*
 * Title: Hw02A.java
 * Abstract: This program print a Horizontal and Vertical Histogram
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 1.5h
 * Date: 8/29/2023
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HW02A {
  public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input file name: ");
        String fileName = scanner.nextLine();
        scanner.close();

        FileReader fr = new FileReader(fileName);
        Scanner fs = new Scanner(fr);
        String test = fs.nextLine();

        System.out.println(test);
        fs.close();
  }
}
