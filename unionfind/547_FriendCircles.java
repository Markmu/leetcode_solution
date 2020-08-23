package unionfind;

class FriendCircles {

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int row = M.length;
        int col = M[0].length;
        UnionSet us = new UnionSet(row);
        for (int i = 0; i < row; ++i) {
            for (int j = i; j < col; ++j) {
                if (M[i][j] == 1) {
                    us.union(i, j);
                }
            }
        }
        return us.getCount();
    }

    static class UnionSet {
        private int count;
        private int[] parent;
        private int[] size;
        
        public UnionSet(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; ++i) {
                this.parent[i] = i;
            }
            this.size = new int[n];
            for (int i = 0; i < n; ++i) {
                this.size[i] = 0;
            }
        }

        public int find(int p) {
            while (p != this.parent[p]) {
                this.parent[p] = this.parent[this.parent[p]];
                p = this.parent[p];
            }
            return p;
        }

        public void union(int i ,int j) {
            int x = find(i);
            int y = find(j);
            if (x == y) return;
            if (this.size[x] > this.size[y]) {
                this.parent[y] = x;
                this.size[x] += this.size[y];
            } else {
                this.parent[x] = y;
                this.size[y] += this.size[x];
            }
            this.count--;
        }

        public int getCount() {
            return this.count;
        }
    }
    
}