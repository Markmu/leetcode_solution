package recursion;

class Solution {

    public int climbStairs(int n) {
        if (n < 2) return 1;
        int f1 = 1;
        int f2 = 1;
        int f3 = f2 + f1;
        for (int i = 2; i <= n; ++i) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /*
     * out of time
     */
    public int climbStairs1(int n) {
        if (n < 2) return 1;
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }
}