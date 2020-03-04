package recursion;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, result, "", n);
        return result;
    }

    private void generate(int left, int right, List<String> result, String s, int n) {
        if (left == right && right == n) {
            result.add(s);
        }
        if (left < n) {
            generate(left + 1, right, result, s + "(", n);
        }
        if (right < left) {
            generate(left, right + 1, result, s + ")", n);
        }
    }
}