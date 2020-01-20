package list;

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        char[] chs = s.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        Stack<Character> stack = new Stack<>();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                stack.push(ch);
                continue;
            }
            if (!stack.isEmpty() && map.get(stack.peek()) == ch) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}