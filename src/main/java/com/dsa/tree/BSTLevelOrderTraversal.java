package com.dsa.tree;

import com.dsa.stack.Stack;
import com.dsa.stack.StackNode;
import com.dsa.stack.StackReversal;

public class BSTLevelOrderTraversal {
    public static void levelOrderTraversal(Stack<Node> s) {
        if (s.isEmpty()) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!s.isEmpty()) {
            StackNode<Node> stackNode = s.pop();
            Node node = stackNode.getData();
            System.out.println(node.getData());
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
        stack = StackReversal.reverseStack(stack);
        levelOrderTraversal(stack);
    }

    public static void main(String[] args) {
        Node head = null;
        head = BinarySearchTree.insert(8, head);
        head = BinarySearchTree.insert(4, head);
        head = BinarySearchTree.insert(12, head);
        head = BinarySearchTree.insert(2, head);
        head = BinarySearchTree.insert(7, head);
        head = BinarySearchTree.insert(10, head);
        head = BinarySearchTree.insert(18, head);
        head = BinarySearchTree.insert(9, head);
        head = BinarySearchTree.insert(11, head);

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(head);

        BSTLevelOrderTraversal.levelOrderTraversal(nodeStack);

        System.out.println();

        head = null;
        head = BinarySearchTree.insert(10, head);
        head = BinarySearchTree.insert(5, head);
        head = BinarySearchTree.insert(14, head);
        head = BinarySearchTree.insert(3, head);
        head = BinarySearchTree.insert(7, head);
        head = BinarySearchTree.insert(12, head);
        head = BinarySearchTree.insert(18, head);
        head = BinarySearchTree.insert(1, head);
        head = BinarySearchTree.insert(4, head);

        head = BinarySearchTree.insert(11, head);
        head = BinarySearchTree.insert(13, head);
        head = BinarySearchTree.insert(15, head);

        nodeStack = new Stack<>();
        nodeStack.push(head);

        BSTLevelOrderTraversal.levelOrderTraversal(nodeStack);
    }
}
