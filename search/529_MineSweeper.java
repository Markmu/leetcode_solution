package search;

class MineSweeper {

    int[] dx = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] dy = new int[] {1, 1, 1, 0, 0, -1, -1, -1};
    char[][] board;

    public char[][] updateBoard(char[][] board, int[] click) {
        this.board = board;
        checkDFS(click[0], click[1]);
        return this.board;
    }

    private void checkDFS(int i, int j) {
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }
        if (board[i][j] == 'E') {
            int mines = getMines(i, j);
            if (mines > 0) {
                board[i][j] = (char)('0' + mines);
            } else {
                board[i][j] = 'B';
                for (int k = 0; k < dx.length; ++k) {
                    int x = i + dx[k]; int y = j + dy[k];
                    if (x >= 0 && x < board.length && y >= 0 && y < board[i].length) {
                        checkDFS(x, y);
                    }
                }
            }
        }
    }
    private int getMines(int i, int j) {
        int mines = 0;
        for (int k = 0; k < dx.length; ++k) {
            int x = i + dx[k]; int y = j + dy[k];
            if (x >= 0 && x < board.length && y >= 0 && y < board[i].length) {
                if (board[x][y] == 'M') {
                    mines++;
                }
            }
        }
        return mines;
    }
}