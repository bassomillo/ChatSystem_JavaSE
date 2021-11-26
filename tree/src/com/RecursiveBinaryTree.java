package com;

import java.util.Stack;

public class RecursiveBinaryTree {
    private static class Node{
        Integer data;
        Node left;
        Node right;

        Node(Integer data){
            this.data = data;
        }

    }

    private void recursive(Node node){
        if(node == null){
            return;
        }
        recursive(node.left);
        recursive(node.right);
    }

    private void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    private void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        inorder(node.right);
        System.out.println(node.data);
    }

    private void stackMethod(Node node){
        Stack<Node> nodes = new Stack<>();
        nodes.push(node);
        while (!nodes.isEmpty()){
            node = nodes.pop();
            System.out.println(node.data);
            if (node.right!=null){
                nodes.push(node.right);
            }
            if (node.left!=null){
                nodes.push(node.left);
            }
        }
    }

    private void levelOrder(Node node){
        SuperArray<Node> nodeSuperArray = new SuperArray<>();
        nodeSuperArray.addToHead(node);
        while (nodeSuperArray.arrayLength()>0){
            Node select = nodeSuperArray.select(nodeSuperArray.arrayLength() - 1);
            nodeSuperArray.delete(nodeSuperArray.arrayLength() - 1);
            System.out.println(select.data);
            if (select.left!=null){
                nodeSuperArray.addToHead(select.left);
            }
            if (select.right!=null){
                nodeSuperArray.addToHead(select.right);
            }

        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        RecursiveBinaryTree recursiveBinaryTree = new RecursiveBinaryTree();
        recursiveBinaryTree.preorder(root);
        recursiveBinaryTree.stackMethod(root);
        recursiveBinaryTree.levelOrder(root);
    }
}
