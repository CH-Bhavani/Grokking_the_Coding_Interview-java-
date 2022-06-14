/*
Given a binary tree, populate an array to represent the averages of all of its levels.
Example 1:
  1  
  2  
  3  
  4  
  5  
  6  
  7  
 [1, 2.5, 5.5] 
 Level Averages: 
Example 2:
 Level Averages: 
  12  
  7  
  1  
  9  
  2  
  10  
  5  
 [12.0, 4.0, 6.5]
*/



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
    public  static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(levelSum / levelSize);
        }
        return  result;
    }


        public static void main(String[] args) {
            TreeNode root = new TreeNode(12);
            root.left = new TreeNode(7);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(9);
            root.left.right = new TreeNode(2);
            root.right.left = new TreeNode(10);
            root.right.right = new TreeNode(5);
            List<Double> result = BFSDemo.findLevelAverages(root);
            System.out.print("Level averages are: " + result);


        }
}
