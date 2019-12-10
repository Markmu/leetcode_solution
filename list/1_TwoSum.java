package list;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
        }
        return res;
    }
}