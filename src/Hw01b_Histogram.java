import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Title: Hw01_Distinct.java
 * Abstract: This program is counting distinct numbers.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 30min
 * Date: 8/29/2023
 */
public class Hw01b_Histogram {
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

        System.out.println("===== Horizontal Histogram =====");
        for (int i = 0; i < size; i++) {
            System.out.print(inputs[i] + ": ");
            for (int j = 0; j < inputs[i]; j++) {
                System.out.print("* ");
            }

            System.out.println(" ");
        }
    }
}
