package unionfind;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {

    private int[][] d = new int[][] {
        {0, 1},
        {1, 0}
    };
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int dummy_node = row * col;
        UnionFind uf = new UnionFind(row * col + 1);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] != '1') {
                    uf.union(i * col + j, dummy_node);
                    continue;
                }
                for (int k = 0; k < d.length; ++k) {
                    int x = d[k][0] + i;
                    int y = d[k][1] + j;
                    if (x < row && y < col && grid[x][y] == '1')
                        uf.union(i * col + j, x * col + y);
                }
            }
        }
        return uf.getCount() - 1;
    }

    static class UnionFind {
        private int count;
        private int[] parent;
        private int[] size;
        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; ++i) {
                this.parent[i] = i;
            }
            this.size = new int[n];
        }
        public int getCount() {
            return this.count;
        }
        public int find(int p) {
            while (p != this.parent[p]) {
                this.parent[p] = this.parent[this.parent[p]];
                p = this.parent[p];
            }
            return p;
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (this.size[rootX] > this.size[rootY]) {
                this.parent[rootY] = rootX;
                this.size[rootX] += this.size[rootY];
            } else if (this.size[rootX] < this.size[rootY]) {
                this.parent[rootX] = rootY;
                this.size[rootY] += this.size[rootX];
            } else {
                this.parent[rootX] = rootY;
                this.size[rootY] += 1;
            }
            this.count--;
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
            {'1'},
            {'1'}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    int[] dx = new int[] {-1, 1, 0, 0};
    int[] dy = new int[] {0, 0, -1, 1};
    char[][] g;
    public int numIslandsDFS(char[][] grid) {
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