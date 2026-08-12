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
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[2];
        res[0] = 0;
        fillKth(root, res, k);
        return res[1];
    }

    private void fillKth(TreeNode root, int[] res, int k) {
        if (root == null) {
            return;
        }

        fillKth(root.left, res, k);
        res[0]++;
        if (res[0] == k) {
            res[1] = root.val;
            return;
        }
        fillKth(root.right, res, k);
    }
}
