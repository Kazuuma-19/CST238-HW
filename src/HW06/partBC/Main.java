package HW06.partBC;

import java.util.ArrayList;
import java.util.Collections;

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
        System.out.println();

        ArrayList<Time> times = new ArrayList<>();
        times.add(new Time(5, 30));
        times.add(new Time(3, 15));
        times.add(new Time(12, 0));
        times.add(new Time(7, 45));

        System.out.println("Before sorting: " + times);

        Collections.sort(times);

        System.out.println("After sorting: " + times);
    }
}
