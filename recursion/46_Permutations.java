package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Set<Integer> contains = new HashSet<>();
        helper(result, new ArrayList<>(), -1, nums, contains);
        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> cur, int pos, int[] nums, Set<Integer> contains) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (contains.contains(i)) continue;
            cur.add(nums[i]);
            contains.add(i);
            helper(result, cur, pos + 1, nums, contains);
            cur.remove(cur.size() - 1);
            contains.remove(i);
        }
    }
}