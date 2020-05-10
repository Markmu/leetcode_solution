package greedy;

class JumpGame_II {

    public int jump(int[] nums) {
        int steps = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            maxPos = nums[i] + i > maxPos ? nums[i] + i : maxPos;
            if (i == end) {
                end = maxPos;
                steps++;
            }
            if (end >= nums.length - 1) {
                break;
            }
        }
        return steps;
    }

    public int jump2(int[] nums) {
        int pos = nums.length - 1;
        int steps = 0;
        while (pos > 0) {
            for (int i = 0; i <= pos; ++i) {
                if (i + nums[i] >= pos) {
                    pos = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}