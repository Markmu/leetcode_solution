package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, new ArrayList<>(), new boolean[nums.length], nums);
        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> cur, boolean[] used, int[] nums) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }

            cur.add(nums[i]);
            used[i] = true;
            helper(result, cur, used, nums);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}