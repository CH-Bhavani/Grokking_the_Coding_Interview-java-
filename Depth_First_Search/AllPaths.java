/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []


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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths=new ArrayList<List<Integer>>();
        List<Integer> currentPath=new ArrayList<>();
        dfs(root,targetSum,currentPath,allPaths);
        return allPaths;
    }
    public static void dfs(TreeNode root,int sum,List<Integer> currentPath,List<List<Integer>> allPaths){
        if(root==null)
            return;
        currentPath.add(root.val);
        if(root.val==sum && root.left==null && root.right==null)
            allPaths.add(new ArrayList<>(currentPath));
        else{
            dfs(root.left,sum-root.val,currentPath,allPaths);
            dfs(root.right,sum-root.val,currentPath,allPaths);
        }
        currentPath.remove(currentPath.size()-1);
    }
    
}
