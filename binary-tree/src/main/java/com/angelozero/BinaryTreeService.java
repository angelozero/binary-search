package com.angelozero;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeService {

    public Node root;
    public List<Integer> nodesList = new ArrayList<>();
    public List<Integer> reverseNodesList = new ArrayList<>();

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int value = node.value;

        if (root == null) {
            root = node;
            return root;

        } else if (value < root.value) {
            root.left = insertHelper(root.left, node);

        } else {
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    public List<Integer> getNodesList() {
        getNodeListHelper(root);
        return this.nodesList;
    }

    private void getNodeListHelper(Node root) {
        if (root != null) {
            getNodeListHelper(root.left);
            nodesList.add(root.value);
            getNodeListHelper(root.right);
        }
    }

    public List<Integer> getReverseNodesList() {
        getReverseNodeListHelper(root);
        return this.reverseNodesList;
    }

    private void getReverseNodeListHelper(Node root) {
        if (root != null) {
            getReverseNodeListHelper(root.right);
            reverseNodesList.add(root.value);
            getReverseNodeListHelper(root.left);
        }
    }

    public boolean search(int value) {
        return searchHelper(root, value);
    }

    private boolean searchHelper(Node root, int value) {

        if (root == null) {
            return false;

        } else if (root.value == value) {
            return true;

        } else if (root.value > value) {
            return searchHelper(root.left, value);

        }

        return searchHelper(root.right, value);

    }

    public void remove(int value) {
        if (search(value)) {
            removeHelper(root, value);
        } else {
            System.out.println("The value " + value + " wasn't found");
        }
    }

    private Node removeHelper(Node root, int value) {
        if (root == null) {
            return root;

        } else if (value < root.value){
            root.left = removeHelper(root.left, value);

        } else if (value > root.value ){
            root.right = removeHelper(root.right, value);

        } else {
            // node found
            if (root.left == null && root.right == null) {
                root = null;

            // find a sucessor to replace this node
            } else if (root.right != null) {
                root.value = successor(root);
                root.right = removeHelper(root.right, root.value);

            // find a predecessor to replace this node
            } else {
                root.value = predecessor(root);
                root.left = removeHelper(root.left, root.value);
            }
        }

        return root;
    }

    private int successor(Node root) {
        // find the least value below the right child of this root node
        root = root.right;

        while (root.left != null){
            root = root.left;
        }
        return root.value;
    }

    private int predecessor(Node root) {
        // find the greatest value below the left child of this root node
        root = root.left;

        while (root.right != null){
            root = root.right;
        }
        return root.value;
    }
}
