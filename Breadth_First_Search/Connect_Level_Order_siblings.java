/*


Given a binary tree, connect each node with its level order successor. The last node of each level should point to a null node.

Example 1:

  1  
  2  
  3  
  4  
  5  
  6  
  7  
 null 
 null 
 null 
Example 2:

  12  
  7  
  1  
  9  
  10  
  5  
 null 
 null 
 null 
 
 
 */
 
 
 import groovyjarjarantlr4.runtime.tree.Tree;

import java.util.*;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right,next;

    public TreeNode(int val) {
        this.val = val;
        left=right=next=null;
    }
    void printLevelOrder() {
        TreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class BFSDemo {
    public  static void connect(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode prev=null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (prev != null)
                    prev.next = currentNode;
                prev = currentNode;
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
    }

            public static void main(String[] args) {
                TreeNode root = new TreeNode(12);
                root.left = new TreeNode(7);
                root.right = new TreeNode(1);
                root.left.left = new TreeNode(9);
                root.right.left = new TreeNode(10);
                root.right.right = new TreeNode(5);
                BFSDemo.connect(root);
                System.out.println("Level order traversal using 'next' pointer: ");
                root.printLevelOrder();
        }
}
