package dp;

class HouseRobberII {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];
        int last = nums[lo]; 
        int cur = Math.max(last, nums[lo + 1]);
        for (int i = lo + 2; i <= hi; ++i) {
            int tmp = cur;
            cur = Math.max(last + nums[i], cur);
            last = tmp;
        }
        return cur;
    }

}