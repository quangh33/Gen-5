package Homework.Nam_Nguyen.Lesson1;

public class LeetCode_304_RangeOfQuery2DImmutable {

    private int[][] sumArray;

    public LeetCode_304_RangeOfQuery2DImmutable(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        sumArray = new int[rows][columns];
        sumArray[0][0] = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            sumArray[i][0] = matrix[i][0];
            for (int j = 1; j < columns; j++) {
                sumArray[i][j] = sumArray[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum+=(col1 == 0 ? sumArray[i][col2] : sumArray[i][col2] - sumArray[i][col1 - 1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[][] = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        LeetCode_304_RangeOfQuery2DImmutable obj = new LeetCode_304_RangeOfQuery2DImmutable(nums);
        int param1 = obj.sumRegion(1,1,2,2);
        System.out.println("param " + param1);
        LeetCode_206_ReverseLinkedList a = new LeetCode_206_ReverseLinkedList();
        a.main();
    }
}
