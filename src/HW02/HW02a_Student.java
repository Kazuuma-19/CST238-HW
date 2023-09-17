package HW02;
/*
* Title: HW02a_Student.java
* Abstract: This program calculates the student average score
* Author: Kazuma Saito
* Email: kasaito@csumb.edu
* Estimate: 2h
* Date: 9/03/2023
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HW02a_Student {
   public static void main(String[] args) throws IOException {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter input file name: ");
       String fileName = scanner.nextLine();
       scanner.close();

       // read input file
       FileReader fr = new FileReader(fileName);
       Scanner fs = new Scanner(fr);

       System.out.println("--------------------------------------------------");
       System.out.println("  Course Report: Quiz Average");
       System.out.println("--------------------------------------------------");

       boolean stopCount = true;

       while (stopCount) {
           String name = fs.next();

           if (!name.equals("STOP")) {
               int studentNumber = fs.nextInt();

               // get scores
               int scoreNum = 5;
               double scores[] = new double[scoreNum];

               for (int j = 0; j < scoreNum; j++) {
                   scores[j] = fs.nextDouble();
               }

               Student st = new Student(name, studentNumber);
               st.getScores(scores);
               st.setAverage();
               System.out.println(st);
           }
           // STOP
           else {
               stopCount = false;
           }
       }
       fs.close();

       System.out.println("--------------------------------------------------");
   }
}

/**
* Student
*/
class Student {
   private String name;
   private int studentNumber;
   private double[] scores;
   private double average;

   public Student(String n, int sn) {
       name = n;
       studentNumber = sn;
   }

   // store scores
   public void getScores(double[] sc) {
       scores = sc;
   }

   // score average
   public void setAverage() {
       double total = 0;
       // To sort in ascending order
       Arrays.sort(scores);

       for (int i = scores.length - 1; i >= 1; i--) {
           total += scores[i];
       }

       average = total / 4;
   }

   public String toString() {
       return "  " + name + "(" + studentNumber + ")" + ": " + average;
   }
}
