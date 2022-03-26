package HomeWorkLesson3;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, k, 0, nums.length-1);
    }

    public static int quickSelect(int[] nums, int k, int start, int end) {
        if (nums.length == 1) return nums[0];
        int indexPivot = partition(nums, start, end);
        if (indexPivot == k) return nums[indexPivot];
        if (indexPivot > k) return quickSelect(nums, k, start, indexPivot - 1);
        return quickSelect(nums, k, indexPivot + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int position = start;
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                swap(array,i,position);
                position++;
            }
        }
        swap(array,position,end);
        return position;
    }
    public static void swap(int[] array, int i, int j) {
        if (i != j) {
            array[i] = array[i] + array[j];
            array[j] = array[i] - array[j];
            array[i] = array[i] - array[j];
        }
    }
    public static void main(String[] args) {
        int[] a = {3, 2, 1,5,6,4};
        int b = findKthLargest(a, 2);
        System.out.println(b);
    }


}
