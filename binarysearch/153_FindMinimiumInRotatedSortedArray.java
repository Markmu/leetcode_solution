package binarysearch;

class FindMinumiumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int min = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[0] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[min];
    }

    public static void main(String[] args) {
        FindMinumiumInRotatedSortedArray f = new FindMinumiumInRotatedSortedArray();
        int[] nums = new int[]{2,1};
        System.out.println(f.findMin(nums));
    }
}