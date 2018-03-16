/**
 * Created by shuoshu on 2018/3/13.
 */
public class LCSTree2 {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = helper(root, true) + helper(root, false) + 1;
        return Math.max(ans, Math.max(longestConsecutive(root.left), longestConsecutive(root.right)));
    }

    private int helper(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }

        int left = 0, right = 0;

        if (flag) {
            if (root.left != null && root.left.val == root.val - 1) {
                left = 1 + helper(root.left, flag);
            }
            if (root.right != null && root.right.val == root.val - 1) {
                right = 1 + helper(root.right, flag);
            }
        } else {
            if (root.left != null && root.left.val == root.val + 1) {
                left = 1 + helper(root.left, flag);
            }
            if (root.right != null && root.right.val == root.val + 1) {
                right = 1 + helper(root.right, flag);
            }
        }

        return Math.max(left, right);
    }
}
