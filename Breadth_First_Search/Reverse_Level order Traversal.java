/*


Given a binary tree, populate an array to represent its level-by-level traversal in reverse order, i.e., the lowest level comes first. You should populate the values of all nodes in each level from left to right in separate sub-arrays.

Example 1:

  1  
  2  
  3  
  4  
  5  
  6  
  7  
 [[4,5,6,7],[2,3],[1]] 
 Reverse Level Order Traversal: 
Example 2:

  12  
  7  
  1  
  9  
  10  
  5  
 [[9,10,5],[7,1],[12]] 
 Reverse Level Order Traversal: 
 
 
 
 
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
    public  static List<List<Integer>> traverseReverseLevelOrder(TreeNode root) {
            List<List<Integer>>  result=new LinkedList<List<Integer>>();
            if(root==null)
                return result;
            Queue<TreeNode> q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()) {
                int levelsize = q.size();
                List<Integer> currentLevel = new ArrayList<>(levelsize);
                for (int i = 0; i < levelsize; i++) {
                    TreeNode curval = q.poll();
                    currentLevel.add(curval.val);
                    if (curval.left != null)
                        q.offer(curval.left);
                    if (curval.right != null)
                        q.offer(curval.right);
                }
                result.add(0,currentLevel);
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
        List<List<Integer>> result = BFSDemo.traverseReverseLevelOrder(root);
        System.out.println("Level order traversal: " + result);
    }
}
