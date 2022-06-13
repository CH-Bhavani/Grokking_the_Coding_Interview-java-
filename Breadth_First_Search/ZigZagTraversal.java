/*Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


*/'
  
  
  
  
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
    public  static List<List<Integer>> ZigZagOrder(TreeNode root) {
            List<List<Integer>>  result=new LinkedList<List<Integer>>();
            if(root==null)
                return result;
            Queue<TreeNode> q=new LinkedList<>();
            q.offer(root);
            boolean zigzag=true;
            while(!q.isEmpty()) {
                int levelsize = q.size();
                List<Integer> currentLevel = new LinkedList<>();
                for (int i = 0; i < levelsize; i++) {
                    TreeNode curval = q.poll();
                    if(zigzag)
                        currentLevel.add(curval.val);
                    else
                        currentLevel.add(0, curval.val);
                    if (curval.left != null)
                        q.offer(curval.left);
                    if (curval.right != null)
                        q.offer(curval.right);
                }
                result.add(currentLevel);
                zigzag=!zigzag;
            }
            return result;
    }


        public static void main(String[] args) {
            TreeNode root = new TreeNode(12);
            root.left = new TreeNode(7);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(9);
            root.right.left = new TreeNode(10);
            root.right.right = new TreeNode(5);
            root.right.left.left = new TreeNode(20);
            root.right.left.right = new TreeNode(17);
            List<List<Integer>> result = BFSDemo.ZigZagOrder(root);
            System.out.println("Zigzag traversal: " + result);

        }
}
