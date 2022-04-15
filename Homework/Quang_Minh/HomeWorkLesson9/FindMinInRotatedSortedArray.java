package HomeWorkLesson9;

public class FindMinInRotatedSortedArray {
    public int binarySearch(int[] nums, int start, int end) {
        if (start == end - 1) return Math.min(nums[start], nums[end]);
        if (nums[start] < nums[end] || start == end) return nums[start];
        int mid = (start + end) / 2;
        if (nums[mid] < nums[start] && nums[mid] < nums[end]) return binarySearch(nums, start, mid);
        return binarySearch(nums, mid, end);
    }

    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }
}
