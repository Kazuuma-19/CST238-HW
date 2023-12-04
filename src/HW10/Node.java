/*
 * Title: Node.java
 * Abstract: This program is a Node object in a BST.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 32h
 * Date: 12/04/2023
 */
package HW10;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Node<T extends Comparable<T>> {
    private Node<T> left;
    private Node<T> right;
    private final T data;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean isLeaf() {
        return !hasLeft() && !hasRight();
    }

    public int compareTo(Node<T> n) {
        return this.data.compareTo(n.data);
    }

    public String toString() {
        return data.toString();
    }

    public void add(T value) {
        int comp = value.compareTo(data);
        if (comp < 0) {
            if (hasLeft()) {
                left.add(value);
            } else {
                left = new Node<>(value);
            }
        } else if (comp > 0) {
            if (hasRight()) {
                right.add(value);
            } else {
                right = new Node<>(value);
            }
        }
        // silently ignore duplicates
    }

    public boolean search(T value) {
        int comp = value.compareTo(data);
        if (comp == 0) {
            return true;
        } else if (comp < 0 && hasLeft()) {
            return left.search(value);
        } else if (comp > 0 && hasRight()) {
            return right.search(value);
        }
        return false;
    }

    public void inOrder(StringBuilder sb) {
        if (hasLeft()) {
            left.inOrder(sb);
        }
        sb.append(data).append(" ");
        if (hasRight()) {
            right.inOrder(sb);
        }
    }

    public void preOrder(StringBuilder sb) {
        sb.append(data).append(" ");
        if (hasLeft()) {
            left.preOrder(sb);
        }
        if (hasRight()) {
            right.preOrder(sb);
        }
    }

    public void postOrder(StringBuilder sb) {
        if (hasLeft()) {
            left.postOrder(sb);
        }
        if (hasRight()) {
            right.postOrder(sb);
        }
        sb.append(data).append(" ");
    }

    public int size() {
        return 1 + (hasLeft() ? left.size() : 0)
                + (hasRight() ? right.size() : 0);
    }

    public int longest() {
        int l = (hasLeft() ? left.longest() : 0);
        int r = (hasRight() ? right.longest() : 0);

        return 1 + Math.max(l, r);
    }

    public int countLessThan(T value) {
        // data >= value
        if (data.compareTo(value) >= 0) {
            if (hasLeft()) {
                return left.countLessThan(value);
            }
            // if there isn't a node which is less than the value
            return 0;
        } else {
            int count = 1;

            if (hasLeft()) {
                count += left.countLessThan(value);
            }

            if (hasRight()) {
                count += right.countLessThan(value);
            }
            return count;
        }
    }

    public int searchHeight(T value, int height) {
        if (data.compareTo(value) == 0) {
            return height;
        } else if (hasLeft() && data.compareTo(value) > 0) {
            return left.searchHeight(value, height + 1);
        } else if (hasRight() && data.compareTo(value) < 0) {
            return right.searchHeight(value, height + 1);
        }
        return -1;
    }

    public T shortestLeafFast(Queue<Node<T>> nodes) {
        if (isLeaf()) {
            return data;
        }
        if (hasLeft()) {
            nodes.add(this.left);
        }
        if (hasRight()) {
            nodes.add(this.right);
        }
        Node<T> next = nodes.poll();
        if (next != null) {
            return next.shortestLeafFast(nodes);
        }

        return null;
    }

    public void orderedList(List<T> ordered) {
        if (hasLeft()) {
            left.orderedList(ordered);
        }

        ordered.add(data);

        if (hasRight()) {
            right.orderedList(ordered);
        }
    }

    public void getRows(List<List<T>> nodes, int row) {
        if (nodes.size() <= row) {
            nodes.add(new ArrayList<>());
        }

        List<T> currentList = nodes.get(row);
        currentList.add(data);

        if (hasLeft()) {
            left.getRows(nodes, row + 1);
        }

        if (hasRight()) {
            right.getRows(nodes, row + 1);
        }
    }

}
