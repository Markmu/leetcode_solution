package search;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {

    int[] dx = new int[] {-1, 1, 0, 0};
    int[] dy = new int[] {0, 0, -1, 1};
    char[][] g;
    public int numIslands(char[][] grid) {
        int islands = 0;
        g = grid;
        for (int i = 0; i < g.length; ++i) {
            for (int j = 0; j < g[i].length; ++j) {
                if (g[i][j] == '0') {
                    continue;
                }
                islands += sink(i, j);
            }
        }
        return islands;
    }

    private int sink(int i, int j) {
        if (g[i][j] == '0') {
            return 0;
        }
        g[i][j] = '0';
        for (int k = 0; k < dx.length; ++k) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < g.length && y >= 0 && y < g[i].length) {
                sink(x, y);
            }
        }
        return 1;
    }

    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        int islands = 0;
        int width = grid.length >= grid[0].length ? grid.length : grid[0].length;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '0') continue;
                islands++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i * width + j);
                grid[i][j] = '0';
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    int curX = cur / width;
                    int curY = cur % width;
                    for (int k = 0; k < dx.length; ++k) {
                        int x = curX + dx[k]; int y = curY + dy[k];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[i].length) {
                            if (grid[x][y] == '0') continue;
                            queue.offer(x * width + y);
                            grid[x][y] = '0';
                        }
                    }
                }
            }
        }
        return islands;
    }
}