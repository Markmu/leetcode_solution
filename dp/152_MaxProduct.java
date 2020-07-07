package dp;

class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;   
        int res = nums[0];
        int curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int max = curMax, min = curMin;
            curMax = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            curMin = Math.min(min * nums[i], Math.min(nums[i], max * nums[i]));
            res = Math.max(curMax, res);
        }
        return res;
    }
}