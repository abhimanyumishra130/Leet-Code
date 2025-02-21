/*
Given a binary tree, determine if it is 
height-balanced
.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
*/

//

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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

         int left = getHeight(root.left, 0);
        if(left == -1) return false;
        int right = getHeight(root.right, 0);
        if(right == -1) return false;
        return Math.abs(right-left) < 2 ?true:false;
    }
    
    public int getHeight(TreeNode root, int height){
        if(root == null) return height;
        int left = getHeight(root.left, height+1);
        if(left == -1) return -1;
        int right = getHeight(root.right, height+1);
        if(right == -1) return -1;
        if(Math.abs(right-left) > 1) return -1;
        return left>right?left:right;
    }
}
