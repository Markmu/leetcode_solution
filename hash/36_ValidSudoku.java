package hash;

import java.util.HashMap;
import java.util.Map;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] cols = new HashMap[9];
        Map<Integer, Integer>[] blocks = new HashMap[9];
        for (int i = 0; i < 9; ++i) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            blocks[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int blockIndex = (i / 3) * 3 + j / 3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
                    blocks[blockIndex].put(n, blocks[blockIndex].getOrDefault(n, 0) + 1);
                    if (rows[i].get(n) > 1 || cols[j].get(n) > 1 || blocks[blockIndex].get(n) > 1) {
                        return false;
                    }
                }               
            }
        }
        return true;
    }
}