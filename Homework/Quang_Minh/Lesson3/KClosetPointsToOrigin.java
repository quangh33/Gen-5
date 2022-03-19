package HomeWorkLesson3;

public class KClosetPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        quickSelect(points, k-1, 0, points.length-1);
        for (int i = 0 ; i < k ; i++){
            result[i] = points[i];
        }
        return result;
    }
    public static int[] quickSelect(int[][] nums, int k, int start, int end) {
        if (nums.length == 1) return nums[0];
        int indexPivot = partition(nums, start, end);
        if (indexPivot == k) return nums[indexPivot];
        if (indexPivot > k) return quickSelect(nums, k, start, indexPivot - 1);
        return quickSelect(nums, k, indexPivot + 1, end);
    }

    public static int partition(int[][] array, int start, int end) {
        int[] random = array[end];
        int position = start;
        for (int i = start; i < end; i++) {
            if (getDistance(array[i]) <= getDistance(random)) {
                swap(array,i,position);
                position++;
            }
        }
        swap(array,position,end);
        return position;
    }
    public static void swap(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static double getDistance(int[]input){
        return Math.pow(input[0],2) + Math.pow(input[1] , 2);
    }
}
