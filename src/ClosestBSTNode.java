/**
 * Created by shuoshu on 2018/3/11.
 */
public class ClosestBSTNode {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int closest = root.val;
        double min = Double.MAX_VALUE;

        while (root != null) {
            if (Math.abs(target - root.val) < min) {
                min = Math.abs(target - root.val);
                closest = root.val;
            }

            if (Math.abs(root.val - target) < 1e-6) {
                return root.val;
            } else if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return closest;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}