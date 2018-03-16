/**
 * Created by shuoshu on 2018/3/13.
 */
public class LCSTree {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root, 1);

        return max;
    }

    private void helper(TreeNode root, int len) {
        if (root == null) {
            max = Math.max(max, len);
            return;
        }

        if (root.left != null) {
            if (root.val + 1 == root.left.val) {
                helper(root.left, len + 1);
            } else {
                helper(root.left, 1);
            }
        }

        if (root.right != null) {
            if (root.val + 1 == root.right.val) {
                helper(root.right, len + 1);
            } else {
                helper(root.right, 1);
            }
        }
    }
}
