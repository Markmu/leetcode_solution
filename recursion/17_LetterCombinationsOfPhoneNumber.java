package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        generateComb(result, phoneMap, new char[digits.length()], digits, 0);
        return result;
    }

    private void generateComb(List<String> result, Map<Character, String> phoneMap, char[] cur, String digits, int pos) {
        if (pos == digits.length()) {
            result.add(new String(cur));
            return;
        }
        String letters = phoneMap.get(digits.charAt(pos));
        for (int i = 0; i < letters.length(); ++i) {
            cur[pos] = letters.charAt(i);
            generateComb(result, phoneMap, cur, digits, pos + 1);
        }
    }
}