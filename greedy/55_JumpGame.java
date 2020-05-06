package greedy;

class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }        
        int canReachable = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= canReachable) {
                canReachable = i;
            }
        }
        return canReachable == 0;
    }
}