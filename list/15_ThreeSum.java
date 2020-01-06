package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 暴力法：
 * 1. 先排序
 * 2. 三重循环暴力迭代搜索
 * 
 * 利用HashMap存储
 * 1. 先排序
 * 2. 然后两重循环判断是否有已经符合的
 * 
 * 双指针法
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length -1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}