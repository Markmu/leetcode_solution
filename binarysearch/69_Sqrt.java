package binarysearch;

class Sqrt {
    public int mySqrt(int x) {
        int left = 0;
        int right = x / 2 + 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}