package HW04.partB;

class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        String str = "ACBCDE";
        q.enqueue(str.charAt(0));
        q.enqueue(str.charAt(1));
        q.enqueue(str.charAt(2));
        q.enqueue(str.charAt(3));
        q.enqueue(str.charAt(4));
        q.enqueue(str.charAt(5));

        System.out.println(q);
        System.out.println();

        q.dequeue();
        q.dequeue();
//        System.out.println(q);
//        System.out.println();

        if (q.isSorted()) {
            System.out.println("Queue is sorted");
        } else {
            System.out.println("Queue is not sorted");
        }
        System.out.println();

        // drop
        String dropStr = "G";
        if (q.drop(dropStr.charAt(0))) {
            System.out.println("The String can drop");
        } else {
            System.out.println("The String cannot drop");
        }
        System.out.println(q);
        System.out.println();

        // indexUsed
        if (q.indexUsed(2)) {
            System.out.println("The index is used");
        } else {
            System.out.println("The index is not used");
        }
        System.out.println();

        //dump
        q.dump();
    }
}
