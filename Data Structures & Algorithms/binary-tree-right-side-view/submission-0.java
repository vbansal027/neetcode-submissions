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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> view = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();

        if (root != null) {
            q.add(root);

            while (!q.isEmpty()) {
                int count = q.size();
                TreeNode last = null;
                while ((count--) > 0) {
                    last = q.remove();
                    if (last.left != null) {
                        q.add(last.left);
                    }
                    if (last.right != null) {
                        q.add(last.right);
                    }
                }
                view.add(last.val);
            }
        }

        return view;
    }
}
