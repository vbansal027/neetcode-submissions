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
    public int diameterOfBinaryTree(TreeNode root) {
        return getDiameterAndHeight(root).first;
    }

    private Pair<Integer, Integer> getDiameterAndHeight(TreeNode root) {
      // base case null node
      if (root == null) {
        // return diameter as 0, and height as -1
        return new Pair<Integer, Integer>(0, -1);
      }

      Pair<Integer, Integer> leftData = getDiameterAndHeight(root.left);
      Pair<Integer, Integer> rightData = getDiameterAndHeight(root.right);

      // update root's height and diameter and return
      Pair<Integer, Integer> currentData = new Pair<>();
      currentData.second = 1 + Math.max(leftData.second, rightData.second);
      currentData.first = Math.max(2 + leftData.second + rightData.second, Math.max(leftData.first, rightData.first));

      return currentData;
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
