package stack;

import java.util.Stack;

class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int min = Math.min(height[i], height[stack.peek()]);
                sum += (min - h) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return sum;
    }

    public int trap2(int[] height) {
        if (height == null || height.length < 2) return 0;
        int sum = 0;
        for (int i = 1; i < height.length - 1; ++i) {
            int leftMax = 0;
            for (int j = i - 1; j >= 0; --j) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = 0;
            for (int j = i + 1; j < height.length; ++j) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int lower = Math.min(leftMax, rightMax);
            if (lower > height[i]) {
                sum += lower - height[i];
            }
        }
        return sum;
    }

    public int trap1(int[] height) {
        if (height == null || height.length < 2) return 0;
        int heightest = 0;
        for (int i = 0; i < height.length; ++i) {
            heightest = Math.max(heightest, height[i]);
        }
        int sum = 0;
        for (int i = 1; i <= heightest; ++i) {
            int piece = 0;
            boolean flag = false;
            for (int j = 0; j < height.length; ++j) {
                if (height[j] >= i) {
                    flag = true;
                    sum += piece;
                    piece = 0;
                }
                if (flag && height[j] < i) {
                    piece += 1;
                }
            }

        }
        return sum;
    }
}