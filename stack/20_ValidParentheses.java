package stack;

import java.util.HashMap;
import java.util.Stack;

class ValidParentheses {
    public boolean isValid2(String s) {
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

    public boolean isValid(String s) {
        // & 1 判断长度是否为奇数
        if (s == null || (s.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}