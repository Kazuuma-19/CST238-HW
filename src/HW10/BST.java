/*
 * Title: BST.java
 * Abstract: This program is a BST object in a BST.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 2h
 * Date: 12/04/2023
 */
package HW10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BST<T> add(T value) {
        if (isEmpty()) {
            root = new Node<>(value);
        } else {
            root.add(value);
        }
        return this;
    }

    public boolean search(T value) {
        return !isEmpty() && root.search(value);
    }

    public String inOrder() {
        if (isEmpty()) {
            return "Empty tree";
        } else {
            StringBuilder sb = new StringBuilder();
            root.inOrder(sb);
            return sb.toString();
        }
    }

    public String preOrder() {
        if (isEmpty()) {
            return "Empty tree";
        } else {
            StringBuilder sb = new StringBuilder();
            root.preOrder(sb);
            return sb.toString();
        }
    }

    public String postOrder() {
        if (isEmpty()) {
            return "Empty tree";
        } else {
            StringBuilder sb = new StringBuilder();
            root.postOrder(sb);
            return sb.toString();
        }
    }

    public int longest() {
        if (isEmpty()) {
            return 0;
        } else {
            return root.longest();
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return root.size();
    }

    public int countLessThan(T value) {
        if (isEmpty()) {
            return 0;
        } else {
            return root.countLessThan(value);
        }
    }

    public int searchHeight(T value) {
        if (isEmpty()) {
            return 0;
        } else {
            return root.searchHeight(value, 1);
        }
    }

    public T shortestLeafValue() {
        if (isEmpty()) {
            return null;
        } else {
            Queue<Node<T>> orderedNodes = new ArrayDeque<>();
            return root.shortestLeafFast(orderedNodes);
        }
    }

    public List<T> orderedList() {
        List<T> ordered = new ArrayList<>();

        if (!isEmpty()) {
            root.orderedList(ordered);
        }

        return ordered;
    }

    public List<List<T>> getRows() {
        List<List<T>> nodes = new ArrayList<>();
        if (!isEmpty()) {
            root.getRows(nodes, 0);
        }
        return nodes;
    }
}



