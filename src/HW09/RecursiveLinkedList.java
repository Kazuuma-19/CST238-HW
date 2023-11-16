/*
 * Title: RecursiveLinkedList.java
 * Abstract: This program makes linked list using recursive
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 3h
 * Date: 11/15/2023
 */
package HW09;

public class RecursiveLinkedList<T extends Comparable<T>> {

    private Node first;

    public RecursiveLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        if (isEmpty()) {
            return "Empty list";
        } else {
            return first.toString();
        }
    }

    public RecursiveLinkedList<T> prepend(T value) {
        Node n = new Node(value);
        n.setNext(first);
        first = n;
        return this;
    }

    public RecursiveLinkedList<T> append(T value) {
        // list is empty
        if (isEmpty()) {
            first = new Node(value);
        } else {
            first.append(value);
        }
        return this;
    }

    public boolean search(T value) {
        // list is empty
        if (isEmpty()) {
            return false;
        } else {
            return first.search(value);
        }
    }

    public RecursiveLinkedList<T> getDistinct() {
        RecursiveLinkedList<T> list = new RecursiveLinkedList<>();
        if (!isEmpty()) {
            first.addIfNotPresent(list);
        }
        return list;
    }

    public boolean isSorted() {
        // empty or only one node
        if (isEmpty() || first.getNext() == null) {
            return true;
        }
        // data < next
        if (first.getData().compareTo(first.getNext().getData()) <= 0) {
            return first.isSortedAscending();
        } else {
            return first.isSortedDescending();
        }
    }

    public RecursiveLinkedList<T> insertOrderedAscending(T value) {
        if (first == null) {
            first = new Node(value);
        }
        // data < first
        else if (value.compareTo(first.data) < 0) {
            Node newNode = new Node(value);
            newNode.next = first;
            first = newNode;
        } else {
            first.insertOrderedAscending(value);
        }
        return this;
    }

    public void rotate() {
        // empty or only one node
        if (isEmpty() || first.getNext() == null) {
            return;
        } else {
            Node second = first.getNext();
            second.moveToEnd(first);
            first = second;
        }
    }

    public void reverse() {
        if (first == null) {
            return;
        }
        Node temp = first;
        first = first.reverse(null);
        temp.next = null;
    }

    public RecursiveLinkedList<T> remove(T value) {
        // empty
        if (isEmpty()) {
            return this;
        }
        Node n = first;
        n.removeNext(value);

        return this;
    }

    class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }

        public boolean hasNext() {
            return next != null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(data).append(" -> ");

            if (next == null) {
                sb.append("null");
            } else {
                sb.append(next.toString());
            }
            return sb.toString();
        }

        public void append(T value) {
            if (next == null) {
                this.next = new Node(value);
            } else {
                next.append(value);
            }
        }

        public boolean search(T value) {
            if (this.data == value) {
                return true;
            }
            // there isn't the value
            if (this.next == null) {
                return false;
            } else {
                return next.search(value);
            }
        }

        public void addIfNotPresent(RecursiveLinkedList<T> list) {
            // if not present, append the value
            if (!list.search(data)) {
                list.append(data);
            }
            if (next == null) {
                return;
            } else {
                next.addIfNotPresent(list);
            }
        }

        public boolean isSortedAscending() {
            if (this.next == null) {
                return true;
            }
            // if data > next
            if (data.compareTo(next.getData()) > 0) {
                return false;
            }
            return next.isSortedAscending();
        }

        public boolean isSortedDescending() {
            if (this.next == null) {
                return true;
            }
            // if data < next
            if (data.compareTo(next.getData()) < 0) {
                return false;
            }
            return next.isSortedDescending();
        }

        public void insertOrderedAscending(T value) {
            if (this.next == null || value.compareTo(this.next.getData()) < 0) {
                Node newNode = new Node(value);
                newNode.setNext(next);
                this.next = newNode;
            } else {
                next.insertOrderedAscending(value);
            }
        }

        public boolean removeNext(T value) {
            // first data == value
            if (this.equals(value)) {
                first = next;
                return true;
            }

            // there isn't the value
            if (this.next == null) {
                return false;
            }
            // if find the value
            if (this.next.equals(value)) {
                next = next.getNext();
                return true;
            }
            return next.removeNext(value);
        }

        public void moveToEnd(Node n) {
            if (this.next == null) {
                this.next = n;
                n.next = null;
            } else {
                next.moveToEnd(n);
            }
        }

        public Node reverse(Node n) {
            if (next == null) {
                this.next = n;
                return this;
            }
            Node reversed = next.reverse(this);
            this.next = n;
            return reversed;
        }

        public boolean equals(T value) {
            return this.data.equals(value);
        }

        public boolean equals(Node n) {
            return this.getData().equals(n.getData());
        }
    }
}
