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
        return getBalanced(root).second;
    }

    private Pair<Integer, Boolean> getBalanced(TreeNode root) {
        if (root == null) {
            return new Pair<Integer, Boolean>(-1, true);
        }

        Pair<Integer, Boolean> leftSub = getBalanced(root.left);
        Pair<Integer, Boolean> rightSub = getBalanced(root.right);

        int h = 1 + Math.max(leftSub.first, rightSub.first);
        int lh = leftSub.first;
        int rh = rightSub.first;
        if (leftSub.second && rightSub.second) {
            return new Pair<Integer, Boolean>(h, (Math.abs(rh-lh) < 2));
        } else {
            return new Pair<Integer, Boolean>(h, false);
        }
    }


    private class Pair<T, V> {
      T first;
      V second;

      Pair() {}

      Pair(T f, V s) {
        this.first = f;
        this.second = s;
      }
    }
}
