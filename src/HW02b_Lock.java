//import java.util.Random;
//import java.util.Scanner;
//import java.util.concurrent.locks.Lock;
//
//public class HW02b_Lock {
//  public static void main(String[] args) {
//    Random r = new Random();
//    Scanner in = new Scanner(System.in);
//    Lock l = new Lock(r.nextInt(40) + 1,
//    r.nextInt(40) + 1,
//    r.nextInt(40) + 1);
//
//    while(l.isLocked()) {
//      int guess;
//      do {
//      System.out.print("Enter guess: ");
//      guess = in.nextInt();
//      } while(guess < 1 || guess > 40);
//      l.guess(guess);
//    }
//
//    System.out.println(l);
//    System.out.println(l.guesses());
//  }
//}
