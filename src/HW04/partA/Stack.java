package HW04.partA;

public class Stack {
    public static final int STACK_CAPACITY = 10;
    private int[] data;
    private int top;

    public Stack() {
        data = new int[STACK_CAPACITY];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (top + 1 == data.length) {
            System.out.println("**Stack full - cannot push " + value + "**");
            return;
        }
        data[++top] = value;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("**Stack empty - cannot pop**");
            return;
        }
        // data[top] = null; // only if stack contains objects
        top--;
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("**Stack empty - returning garbage value**");
            return 0;
        }
        return data[top];
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (isEmpty()) {
            sb.append("Empty");
        } else {
            for (int i = top; i >= 0; i--) {
                sb.append(data[i]);
            }
        }
        return sb.toString();
    }
}