package recursion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {

    public int majorityElement(int[] nums) {
        return majorityHelper(nums, 0, nums.length - 1);
    }

    private int majorityHelper(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        int left = majorityHelper(nums, l, mid);
        int right = majorityHelper(nums, mid + 1, r);
        if (left == right) return left;

        int leftCount = countMajority(nums, left, l, mid);
        int rightCount = countMajority(nums, right, mid + 1, r);

        return leftCount > rightCount ? left : right;
    }

    private int countMajority(int[] nums, int target, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; ++i) {
            if (target == nums[i]) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        Map.Entry<Integer, Integer> majority = null;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (majority == null || entry.getValue() > nums.length / 2) {
                majority = entry;
            }
        }
        return majority.getKey();
    }
}