package recursion;

import java.util.LinkedList;
import java.util.List;

class Solution {
    
    private List<List<Integer>> result = new LinkedList<>();
    private int n;
    private int k;
    
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        helper(new LinkedList<>(), 1);
        return result;
    }
    
    private void helper(LinkedList<Integer> comb, int index) {
        if (comb.size() == k) {
            result.add(new LinkedList<Integer>(comb));
            return;
        }
        for (int i = index; i <= n; ++i) {
            comb.add(i);
            helper(comb, i + 1);
            comb.removeLast();
        }
    }
}