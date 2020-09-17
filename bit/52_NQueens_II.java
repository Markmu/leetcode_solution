package bit;

class NQueens_II {

    public int totalNQueens(int n) {
        dfs(n, 0, 0, 0, 0);
        return this.count;
    }

    private int count = 0;

    private void dfs(int n, int row, int cols, int ld, int rd) {
        if (row == n) {
            this.count++;
            return;
        }
        // 获取当前所有皇后共同能影响到的列    （将前面的位忽略只保留需要的后n位）
        int bits = (~(cols | ld | rd)) & ((1 << n) - 1);
        while (bits != 0) {
            int pos = bits & -bits;
            bits = bits & (bits - 1);
            dfs(n, row + 1, cols | pos, (ld | pos) << 1, (rd | pos) >> 1);
        }
    }
}