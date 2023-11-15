package HW09;

import java.util.Random;

public class Hw09_LinkedListTester {
    public static void main(String[] args) {
        RecursiveLinkedList<Integer> rll = new RecursiveLinkedList<>();
        Random r = new Random(9);
        // this loop is NOT part of the code you will turn in
        for (int i = 0; i < 10; i++) {
            rll.append(r.nextInt(-20, 20));
        }
        System.out.println(rll);

        // search
        System.out.println("9: " + rll.search(9));
        System.out.println();

        for (int i = 0; i < 10; i++) {
            int remove = r.nextInt(-20, 20);
            System.out.printf("attempting to remove %d%n", remove);
            rll.remove(remove);
            System.out.println(rll);
            System.out.println();
        }
//        rll.remove(9).remove(-7);
//        System.out.println(rll);
//        System.out.println();

        rll.prepend(9).append(-7);
        System.out.println(rll);
        System.out.println("\nGetting distinct values: ");
        RecursiveLinkedList<Integer> r2 = rll.getDistinct();
        System.out.println("Original: " + rll);
        System.out.println("Distinct: " + r2);

        RecursiveLinkedList<String> test = new RecursiveLinkedList<>();
        test.append("chocolate");
        test.append("banana");
        test.append("apple");
        System.out.println("Is sorted? " + test.isSorted());

        RecursiveLinkedList<String> r3 = new RecursiveLinkedList<>();
        r3.insertOrderedAscending("hello");
        r3.insertOrderedAscending("ciao");
        r3.insertOrderedAscending("goodbye");
        r3.insertOrderedAscending("hola");
        System.out.println("\nOrdered Strings: " + r3);
        System.out.println("Is sorted? " + r3.isSorted());

        System.out.println();
        System.out.println("Rotating!");
        rll.rotate();
        rll.rotate();
        rll.rotate();
        System.out.println("done!");
        System.out.println(rll);

        System.out.println();
        System.out.println("Reversing!");
        rll.reverse();
        System.out.println("done!");
        System.out.println(rll);
    }
}
