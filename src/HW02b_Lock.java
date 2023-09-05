/*
 * Title: HW02b_Lock.java
 * Abstract: This program is a number guessing game
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 1.5h
 * Date: 9/5/2023
 */

import java.util.Random;
import java.util.Scanner;

public class HW02b_Lock {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        Lock l = new Lock(r.nextInt(40) + 1,
                r.nextInt(40) + 1,
                r.nextInt(40) + 1);

        while (l.isLocked()) {
            int guess;
            do {
                System.out.print("Enter guess: ");
                guess = in.nextInt();
            } while (guess < 1 || guess > 40);
            l.guess(guess);
        }

        System.out.println(l);
        System.out.println(l.guesses());
    }
}

class Lock {
    private int[] codes;
    private int currentCode;
    private int[] allGuesses;
    private int guessCount;

    public Lock(int firstNum, int secondNum, int thirdNum) {
        codes = new int[3];
        allGuesses = new int[120];

        codes[0] = firstNum;
        codes[1] = secondNum;
        codes[2] = thirdNum;

        currentCode = 0;
        guessCount = 0;
    }

    public boolean isLocked() {
        if (currentCode != 3) {
            return true;
        }
        // guess all numbers
        else {
            return false;
        }
    }

    // store the num of user's guess
    public void guess(int g) {
        if (1 <= g && g <= 40) {
            allGuesses[guessCount++] = g;
        }

        if (g == codes[currentCode]) {
            System.out.println("Correct");
            currentCode++;
        }
        // guess is greater than correct number
        else if (codes[currentCode] < g) {
            System.out.println("Go down");
        }
        // guess is less than correct number
        else {
            System.out.println("Go up");
        }
    }

    // return all the user guesses
    public String guesses() {
        StringBuilder sb = new StringBuilder();
        sb.append(guessCount + " guesses ");

        for (int allGuesse : allGuesses) {
            if (allGuesse != 0) {
                sb.append(allGuesse + " ");
            }
        }
        return sb.toString();
    }

    // return answer number
    public String toString() {
        StringBuilder sb = new StringBuilder("The codes are: ");

        for (int code : codes) {
            if (code != 0) {
                sb.append(code + " ");
            }
        }
        return sb.toString();
    }
}
