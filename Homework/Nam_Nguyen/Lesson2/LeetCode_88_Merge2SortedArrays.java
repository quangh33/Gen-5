package Homework.Nam_Nguyen.Lesson2;

public class LeetCode_88_Merge2SortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int indexOfNums1 = m - 1;
        int indexOfResultArray = m + n - 1;

        if(m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        for (int indexOfNums2 = n - 1; indexOfNums2 >= 0 && indexOfNums1 >= 0;) {
            if(nums2[indexOfNums2] >= nums1[indexOfNums1]){
                nums1[indexOfResultArray] = nums2[indexOfNums2];
                indexOfResultArray--;
                indexOfNums2--;
            }else{
                while(indexOfNums1 >= 0 && nums1[indexOfNums1] > nums2[indexOfNums2]) {
                    nums1[indexOfResultArray] = nums1[indexOfNums1];
                    indexOfNums1--;
                    indexOfResultArray--;
                }
            }
        }

        if(indexOfNums1 < 0) {
            for (int i = 0; i <= indexOfResultArray; i++) {
                nums1[i] = nums2[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1}; //j
        int m = 1;
        int[] nums2 = {0}; // i
        int n = 0;
        merge(nums1, m, nums2, n);
    }
}
