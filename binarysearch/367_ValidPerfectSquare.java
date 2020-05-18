package binarysearch;

class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num / 2 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sqrt = (long) mid * mid;
            if (sqrt == num) {
                return true;
            } else if (sqrt > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}