package HomeWorkLesson11;

public class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        int res = 0, n = arr.length;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && arr[j + 1] > arr[j]) j++;
            int k = j;
            while (k + 1 < n && arr[k + 1] < arr[k]) k++;
            if (j != k && i != j) {
                res = Math.max(res, k - i + 1);
            }
            if (i != k) {
                i = k;
            } else {
                i++;
            }
        }
        return res;

    }
}
