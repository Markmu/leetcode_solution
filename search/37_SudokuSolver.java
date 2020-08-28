package search;

class SudokuSolver {


    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; ++c) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x, int y, char c) {
        int blkRow = (x / 3) * 3; int blkCol = (y / 3) * 3;
        for (int i = 0; i < 9; ++i) {
            if (board[i][y] == c || 
                board[x][i] == c ||
                board[blkRow + i / 3][blkCol + i % 3] == c) 
                return false;
        }
        return true;
    }

}