package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), new HashSet<>(), new HashSet<>(), n);
        return result;
    }

    private void dfs(List<List<String>> result, List<Integer> col, Set<Integer> p, Set<Integer> q, int n) {
        if (col.size() >= n) {
            result.add(toSolution(col));
            return;
        }
        int r = col.size() + 1;
        for (int c = 1; c <= n; ++c) {
            if (col.contains(c) || p.contains(r - c) || q.contains(r + c))
                continue;
            col.add(c);
            p.add(r - c);
            q.add(r + c);
            dfs(result, col, p, q, n);
            col.remove(col.size() - 1);
            p.remove(r - c);
            q.remove(r + c);
        }
    }

    private List<String> toSolution(List<Integer> queens) {
        List<String> solution = new ArrayList<>();
        for (int i: queens) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < i; j++)
                sb.append('.');
            sb.append('Q');
            for (int j = i + 1; j <= queens.size(); j++) 
                sb.append('.');
            solution.add(sb.toString());
        }
        return solution;
    }
}