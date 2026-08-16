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
    public int goodNodes(TreeNode root) {
        int[] a = new int[]{0, Integer.MIN_VALUE};
        computeGoodNodes(root, a);
        return a[0];
    }

    private void computeGoodNodes(TreeNode r, int[] a) {
        if (r != null) {
            if (r.val >= a[1]) {
                // this means this node is the hightest value till now on this path
                // => for all paths under this node, it's value should be the immediate high
                // but the recursion un-wraps old value shold be preserved
                int maxBeforeRoot = a[1];
                a[1] = r.val;
                a[0]++;
                computeGoodNodes(r.left, a);
                computeGoodNodes(r.right, a);
                // restore old value now
                a[1] = maxBeforeRoot;
            } else {
                computeGoodNodes(r.left, a);
                computeGoodNodes(r.right, a);
            }
        }
    }
}
