package HomeWorkLesson3;

import java.util.ArrayList;
import java.util.List;

public class MergeSorterdArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int indexResult = 0;
        int[] nums1Temp = new int[nums1.length];
        for (i = 0 ; i < nums1.length ; i++){
            nums1Temp[i] = nums1[i];
        }
        i = 0;
        while (true) {
            if (i >= m || j >= n) break;
            if (nums1Temp[i] < nums2[j]) {
                nums1[indexResult] = nums1Temp[i];
                i++;

            } else {
                nums1[indexResult] = nums2[j];
                j++;

            }
            indexResult++;
        }
        while (i < m) {
            nums1[indexResult] = nums1Temp[i];
            i++;
            indexResult++;
        }
        while (j < n) {
            nums1[indexResult] = nums2[j];
            j++;
            indexResult++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1,m,nums2,n);
        for (int i = 0 ; i < 6 ; i++){
            System.out.print(nums1[i] + " ");
        }
    }
}
