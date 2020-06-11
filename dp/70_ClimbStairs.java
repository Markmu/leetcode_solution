package dp;

class ClimbStairs {

    public int climbStairs(int n) {
        if (n < 2) return 1;
        int f1 = 1;
        int f2 = 1;
        int f3 = 2;
        for (int i = 2; i <= n; ++i) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}