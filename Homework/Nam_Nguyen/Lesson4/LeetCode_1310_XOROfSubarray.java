package Homework.Nam_Nguyen.Lesson4;

public class LeetCode_1310_XOROfSubarray {

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixArr = new int[arr.length];
        int[] result = new int[queries.length];
        prefixArr[0] = arr[0];
        for (int i = 1; i < prefixArr.length; i++) {
            prefixArr[i] = prefixArr[i-1] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == 0)  result[i] = prefixArr[end];
            else result[i] = prefixArr[start-1] ^ prefixArr[end];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
        xorQueries(arr, queries);
    }
}
