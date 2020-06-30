package dp;

class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[n - 1][m - 1] == 1) return 0;
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = 1;
        // init the last column
        for (int i = n - 2; i >= 0; --i) {
            dp[i][m - 1] = obstacleGrid[i][m - 1] == 1 ? 0 : dp[i + 1][m - 1];
        }
        // init the last row
        for (int i = m -2 ; i >= 0; --i) {
            dp[n - 1][i] = obstacleGrid[n - 1][i] == 1 ? 0 : dp[n - 1][i + 1];
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = m - 2; j >= 0; --j) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[0][0];
    }
}