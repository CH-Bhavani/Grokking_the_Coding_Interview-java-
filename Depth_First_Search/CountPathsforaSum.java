/*


Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’. Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).

 Example 1: 
  1  
  7  
  9  
  6  
  5  
  2  
  3  
 S: 12Output: 3Explaination: There are three paths with sum '12':7 -> 5, 1 -> 9 -> 2, and 9 -> 3 
 Example 2: 
  12  
  7  
  1  
  4  
  10  
  5  
 S: 11Output: 2Explaination: Here are the two paths with sum '11':7 -> 4 . and 1 -> 10.   
Try it yourself #


Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

Example 1:


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3



*/




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> l=new LinkedList<>();
        return dfs(root,l,targetSum);
        
    }
    public static int dfs(TreeNode root,List<Integer> l,int ts){
        if(root==null)
            return 0;
        l.add(root.val);
        int count=0,sum=0;
        ListIterator<Integer> itr=l.listIterator(l.size());
        while(itr.hasPrevious()){
            sum+=itr.previous();
            if(sum==ts)
                count++;
        }
        count+=dfs(root.left,l,ts);
        count+=dfs(root.right,l,ts);
        l.remove(l.size()-1);
        return count;
    }
}



