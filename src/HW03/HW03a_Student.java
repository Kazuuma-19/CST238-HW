package HW03;
/*
 * Title: HW03a_Student.java
 * Abstract: "This program checks the course registration status
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 2h
 * Date: 09/10/2023
 */
public class HW03a_Student {
    public static void main(String[] args) {
        Course c1 = new Course("Intro to Everything", 123, "Dr. Gross");
        Student s1 = new Student("Jane", 1234);
        Student s2 = new Student("Phillipe", 1235);
        Student s3 = new Student("Lu", 1236);
        Student s4 = new Student("Enrique", 1237);
        s1.setName("Kazuma");
        c1.add(s1);
        c1.add(s2);
        c1.add(s3);
        c1.add(s4);
        c1.print();
        c1.remove(s1);
        c1.print();
//        System.out.println(s1);
//        System.out.println(c1);
    }
}

class Student {
    private String name;
    private int id;

    public Student(String n, int i) {
        name = n;
        id = i;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String n) {
        name = n;
    }

    // compare id
    public boolean equals(Student st) {
        return id == st.getId();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name);
        sb.append(" - ");
        sb.append("ID: " + id);
        System.out.println();
        return sb.toString();
    }
}

class Course {
    private String title;
    private int number;
    private String instructorName;
    private int enrolledNumber;
    private int classCapacity;
    private Student[] roster;

    public Course(String t, int n, String i) {
        title = t;
        number = n;
        instructorName = i;
        enrolledNumber = 0;
        classCapacity = 30;
        roster = new Student[classCapacity];
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public boolean add(Student s) {
        boolean isEnrolled = true;

        for (int i = 0; i < enrolledNumber; i++) {
            if (roster[i].equals(s) || enrolledNumber == classCapacity) {
                isEnrolled = false;
            }
        }

        if (isEnrolled) {
            roster[enrolledNumber++] = s;
        }

        return isEnrolled;
    }

    public boolean remove(Student s) {
        boolean isEnrolled = false;

        for (int i = 0; i < enrolledNumber; i++) {
            if (roster[i].equals(s)) {
                for (int j = i; j < enrolledNumber - 1; j++) {
                    roster[j] = roster[j + 1];
                }

                isEnrolled = true;
                enrolledNumber--;
            }
        }
        return isEnrolled;
    }

    public void print() {
        System.out.println("Course Title: " + title);
        System.out.println("Course Number: " + number);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Enrollment: " + enrolledNumber);

        for (int i = 0; i < enrolledNumber; i++) {
            System.out.print("  Name: " + roster[i].getName());
            System.out.print(" - ");
            System.out.print("ID: " + roster[i].getId());
            System.out.println();
        }
    }

    // compares the title and number
    public boolean equals(Course co) {
        return number == co.number && title.equals(co.title);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course Title: " + title);
        sb.append("\n");
        sb.append("Course Number: " + number);
        sb.append("\n");
        sb.append("Instructor: " + instructorName);
        return sb.toString();
    }
}
