package HW10;

import java.util.*;

public class BSTRunner {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for (int i = -20; i < 21; i++) {
            data.add(i);
            data.add(i);
        }

        Scanner s = new Scanner(System.in);
        System.out.print("Enter seed for shuffling: ");
        int seed = s.nextInt();
        Random rand = new Random(seed);
        Collections.shuffle(data, rand);

        BST<Integer> b1 = new BST<>();
        System.out.print("appending ");
        for (int i = 0; i < 20; i++) {
            int n = data.get(i);
            System.out.print(n + " ");
            b1.add(n);
        }
        System.out.println("\n");

        System.out.println("shortest leaf: " + b1.shortestLeafValue());
        System.out.printf("Longest: %d, Shortest Leaf: %d%n",
                b1.longest(), b1.searchHeight(b1.shortestLeafValue()));
        System.out.println();
        System.out.println("In order: " + b1.inOrder());
        System.out.println();


        System.out.print("Ordered elements: " + b1.orderedList());
        System.out.println();

        List<List<Integer>> rows = b1.getRows();
        System.out.println(rows);

        System.out.print("Count values less than: ");
        int value = s.nextInt();
        System.out.printf("Values < %d: %d%n", value, b1.countLessThan(value));

    }
}
