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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList();

        if (root != null) {

            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);

            while (!q.isEmpty()) {
                int count = q.size();
                List<Integer> nodes = new ArrayList();
                while ((count--)>0) {
                    TreeNode node = q.remove();
                    nodes.add(node.val);
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
                ans.add(nodes);
            }

        }

        return ans;
    }
}
