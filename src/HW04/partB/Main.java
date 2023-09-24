package HW04.partB;

class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        String str = "ACB";
        q.enqueue(str.charAt(0));
//        q.enqueue(str.charAt(1));
//        q.enqueue(str.charAt(2));
//        q.enqueue(str.charAt(3));
//        q.enqueue(str.charAt(4));
//        q.enqueue(str.charAt(5));


        System.out.println(q);

//        for (int i = 0; i < 1; i++) {
//            q.dequeue();
//        }
//        System.out.println(q);

        if (q.isSorted()) {
            System.out.println("Queue is sorted");
        } else {
            System.out.println("Queue is not sorted");
        }
    }
}
