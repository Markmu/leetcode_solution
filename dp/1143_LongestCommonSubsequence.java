package dp;

class LongestCommonSubsequence {
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int n = text1.length();
        int m = text2.length();
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; ++i) {
            int last = 0;
            for (int j = 1; j <= m; ++j) {
                int temp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = last + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                last = temp;
            }
        }
        return dp[m];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) return 0;
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}