package hash;

import java.util.HashMap;
import java.util.Map;

class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < map.length; ++i) {
            if (map[i] != 0) return false;
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        for (char ch : t.toCharArray()) {
            if (map.get(ch) == null || map.get(ch) < 1) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        for (int v : map.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}