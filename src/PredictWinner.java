/**
 * Created by shuoshu on 2018/3/10.
 */
public class PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = Math.max(nums[i - 1] - dp[i + 1][j], nums[j - 1] - dp[i][j - 1]);
            }
        }

        return dp[1][n] >= 0;
    }

}
