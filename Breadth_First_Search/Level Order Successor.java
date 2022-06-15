/*

Given a binary tree and a node, find the level order successor of the given node in the tree. The level order successor is the node that appears right after the given node in the level order traversal.

Example 1:

 3 
 4 
 Given Node: 
 Level Order Successor: 
  1  
  2  
  3  
  4  
  5  
Example 2:

 Given Node: 
 9 
 Level Order Successor: 
 10 
  12  
  7  
  1  
  9  
  10  
  5  
Example 3:

 Given Node: 
 Level Order Successor: 
 12 
 7 
  12  
  7  
  1  
  9  
  10  
  5  
  
  
  */





import groovyjarjarantlr4.runtime.tree.Tree;

import java.util.*;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BFSDemo {
    public  static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);
            if (currentNode.val == key)
                break;
        }
        return  queue.peek();
    }


        public static void main(String[] args) {
                TreeNode root = new TreeNode(12);
                root.left = new TreeNode(7);
                root.right = new TreeNode(1);
                root.left.left = new TreeNode(9);
                root.right.left = new TreeNode(10);
                root.right.right = new TreeNode(5);
                TreeNode result = BFSDemo.findSuccessor(root, 12);
                if (result != null)
                    System.out.println(result.val + " ");
                result = BFSDemo.findSuccessor(root, 9);
                if (result != null)
                    System.out.println(result.val + " ");
        }
}
