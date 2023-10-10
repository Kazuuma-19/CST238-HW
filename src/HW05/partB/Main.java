package HW05.partB;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println("Capacity (should be 5): " + q.getCapacity());
        System.out.println("Size (should be 0): " + q.getSize());
        System.out.println();
        for (int i = 0; i < q.getCapacity(); i++) {
            q.enqueue(q.getCapacity() - i);
        }
        System.out.println("Size (should be 5): " + q.getSize());
        System.out.println(q.printable());
        System.out.println();
        for (int i = 0; i < 3; i++) {
            q.dequeue();
        }
        System.out.println("Size (should be 2): " + q.getSize());
        System.out.println(q.printable());
        System.out.println();
//        q.enqueue(-1);
//        q.enqueue(-2);
//        q.enqueue(-3);
//        System.out.println(q.printable());
//        q.enqueue(-4);
////        q.enqueue(-5);

        for (int i = 0; i < 5; i++) {
            q.enqueue((i + 1) * -1);
        }
        System.out.println("Capacity (should be 11): " + q.getCapacity());
        System.out.println("Size (should be 7): " + q.getSize());
        System.out.println(q.printable());
    }
}
