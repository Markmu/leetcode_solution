package dp;

class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = dp[0] = nums[0];
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = Math.max(0, dp[i-1]) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubArray().maxSubArray(new int[] {1, 2}));
    }
}