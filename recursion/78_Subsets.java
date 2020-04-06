package recursion;

import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), 0, 0, nums);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> cur, int setLength, int pos, int[] nums) {
        if (setLength > nums.length) return;
        if (cur.size() == setLength) {
            result.add(new ArrayList<>(cur));
        }
        for (int i = pos; i < nums.length; i++) {
            cur.add(nums[i]);
            helper(result, cur, setLength + 1, i + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }
}