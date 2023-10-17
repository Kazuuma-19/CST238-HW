package HW06.partBC;

public class Main {
    public static void main(String[] args) {
        Time t1 = new Time(12, 55);
        Time t2 = new Time(29, 34);
        Time t3 = new Time(3, 45);
        Time t4 = new Time(22, 33);
        System.out.println(t1.toStandard() + " - " + t1);
        System.out.println(t2.toStandard() + " - " + t2);
        System.out.println(t3.toStandard() + " - " + t3);
        System.out.println(t4.toStandard() + " - " + t4);
        Time t5 = t3.add(t4);
        System.out.println(t5.toStandard() + " - " + t5);
        Time t6 = new Time();
        Time t7 = new Time(12);
        System.out.println(t6.toStandard() + " - " + t6);
        System.out.println(t7.toStandard() + " - " + t7);

        System.out.println();
        Time t8 = new Time(23, 45);
        Time t9 = new Time(0, 16);
        Time t10 = t8.add(t9);
        System.out.println(t10.toStandard() + " - " + t10);
    }
}
