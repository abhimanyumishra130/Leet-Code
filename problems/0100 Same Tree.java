/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }

    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null || q == null) return p == null & q==null;
        if(p.val != q.val) return false;
        boolean left = true;
        boolean right = true;
        if(p.left!=null || q.left != null){
            if(p.left==null || q.left == null) return false;
            left = isSame(p.left, q.left);
        }

        if(p.right!=null || q.right != null){
            if(p.right==null || q.right == null) return false;
            right = isSame(p.right, q.right);
        }

        return left && right;
    }
}
