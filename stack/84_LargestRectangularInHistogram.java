package array;

import java.util.Stack;

class Solution {
    
    /**
     * Brutal
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            for (int j = i; j < heights.length; ++j) {
                int min = Math.min(heights[i], heights[j]);
                for (int k = i; k <= j; ++k) {
                    min = Math.min(min, heights[k]);
                }
                int res = (j - i + 1) * min;
                max = res > max ? res : max;
            }
        }
        return max;
    }

    /**
     * Optimized Brutal
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            int left = i;
            int right = i;
            while (left >= 0 && heights[left] >= heights[i]) left--;
            while (right < heights.length && heights[right] >= heights[i]) right++;
            max = Math.max(max, (heights[i] * (right - left - 1)));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                max = Math.max(max, height * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            max = Math.max(max, height * (heights.length - stack.peek() - 1));
        }
        return max;
    }
}