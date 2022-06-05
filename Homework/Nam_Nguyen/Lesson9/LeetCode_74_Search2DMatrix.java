package Homework.Nam_Nguyen.Lesson9;

public class LeetCode_74_Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m - 1;
        while(low <= high) {    // find row
            int mid = low + (high - low)/2;
            if(matrix[mid][0] <= target && target <= matrix[mid][n-1]) {
                row = mid;
                break;
            }
            if(matrix[mid][0] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        low = 0;
        high = n - 1;
        while(low <= high) {    // find cell
            int mid = low + (high - low)/2;
            if(matrix[row][mid] > target) {
                high = mid - 1;
            }else if(matrix[row][mid] < target) {
                low = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        int target = 25;
        System.out.println("res "+searchMatrix(matrix, target));
    }
    
}
