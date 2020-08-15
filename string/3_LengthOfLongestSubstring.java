package string;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        int result = 0;
        int[] index = new int[128];
        int start = 0;
        for (int i = 0; i < n; ++i) {
            start = Math.max(index[s.charAt(i)], start);
            result = Math.max(start - i + 1, result);
            index[s.charAt(i)] = i + 1;
        }
        return result;
    }
}