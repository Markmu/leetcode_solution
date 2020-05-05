package greedy;

import java.util.Arrays;

class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int satisfied = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[i]) {
                satisfied++;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return satisfied;
    }
}