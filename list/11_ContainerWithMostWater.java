package list;

class Solution {

    /**
     * brutal force
     * 
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        if (height == null || height.length == 0) return 0;

        int capacity = 0;

        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                int shorter = Math.min(height[i], height[j]);
                capacity = Math.max(capacity, (j - i) * shorter);
            }
        }
        return capacity;
    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int capacity = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            capacity = Math.max(capacity, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return capacity;
    }
}