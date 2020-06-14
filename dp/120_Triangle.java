package dp;

import java.util.List;

class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        int[] dp = new int[lastRow.size()];
        for (int i = 0; i < lastRow.size(); ++i) {
            dp[i] = lastRow.get(i);
        }
        for (int i = lastRow.size() - 2; i >= 0; --i) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); ++j) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int row = triangle.size();
        int col = triangle.get(row - 1).size();

        int[][] dp = new int[row][col];
        for (int i = 0; i < col; ++i) {
            dp[row - 1][i] = triangle.get(row - 1).get(i);
        }

        for (int i = row - 2; i >= 0; --i) {
            List<Integer> rowList = triangle.get(i);
            for (int j = 0; j < rowList.size(); ++j) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + rowList.get(j);
            }
        }
        return dp[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[] dp = new int[col];
        dp[0] = triangle.get(0).get(0);
        int prev = 0, cur;
        for (int i = 1; i < row; ++i) {
            for (int j = 0; j <= i; ++j) {
                cur = dp[j];
                if (j == 0) {
                    dp[j] = cur + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[j] = prev + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(prev, cur) + triangle.get(i).get(j);
                }
                prev = cur;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; ++i) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][col];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < row; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; ++i) {
            res = Math.min(res, dp[row - 1][i]);
        }
        return res;
    }
}   