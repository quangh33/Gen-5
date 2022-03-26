package Homework.Nam_Nguyen.Lesson2;

public class LeetCode_973_KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int k) {

        int[] nums = new int[points.length];
        int[][] kPointsClosestToOrigin = new int[k][2];
        int count = 0;

        for (int i = 0; i < points.length; i++) {
            nums[i] = points[i][0]*points[i][0] + points[i][1] * points[i][1];
            if(nums[i] <= k)    count++;
        }

        if(count == k) return points;

        count = 0;
        int minDistanceToOrigin = findSmallest(0, nums.length - 1, nums, k);

        for (int i = 0; i < points.length; i++) {
            if(points[i][0]*points[i][0] + points[i][1] * points[i][1] <= minDistanceToOrigin){
                kPointsClosestToOrigin[count] = points[i];
                count++;
            }
        }

        return kPointsClosestToOrigin;
    }

    public static int findSmallest(int low, int high, int[] nums, int k) {

        int pivotLocation = partition(low, high, nums);

        if(pivotLocation == k - 1){
            return nums[pivotLocation];
        }

        if(pivotLocation < k - 1)
            return findSmallest(pivotLocation + 1, high, nums, k);

        return findSmallest(low, pivotLocation - 1, nums, k);
    }

    public static int partition(int low, int high, int[] nums) {
        int pivot = nums[high];
        int pivotLocation = low;
        int temp;

        for (int i = low; i <= high; i++) {
            if(nums[i] < pivot) {
                temp = nums[i];
                nums[i] = nums[pivotLocation];
                nums[pivotLocation] = temp;
                pivotLocation++;
            }
        }

        temp = nums[high];
        nums[high] = nums[pivotLocation];
        nums[pivotLocation] = temp;

        return pivotLocation;
    }

    public static void main(String[] args) {
        int[][] points = {{1,3}, {-2,2}, {2,-2}};
        int k = 2;
        int[][] res = kClosest(points, k);
    }
    
}
