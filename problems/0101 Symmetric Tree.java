/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?
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
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null || root.right == null) return root.left == null && root.right == null;
        return isSymmetry(root.left, root.right);
    }

    public boolean isSymmetry(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == null && right == null;
        if(left.val != right.val) return false;

        boolean l = true;
        boolean r = true;
        if(left.left != null || right.right !=null){
            if(left.left == null || right.right == null) return false;
            l = isSymmetry(left.left, right.right);
        }

        if(left.right != null || right.left !=null){
            if(left.right == null || right.left == null) return false;
            r = isSymmetry(left.right, right.left);
        }

        return l && r;
    }
}
