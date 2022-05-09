package Homework.Nam_Nguyen.Lesson11;

public class LeetCode_845_LongestMountainInArray {

    public int longestMountain(int[] arr) {
        int longestPath = 0;
        int i = 0;
        int size = arr.length;
        while(i < size) {
            int j = i;
            while(j < size - 1 && arr[j] < arr[j+1]) j++;
            int peek = j;
            while(peek < size - 1 && arr[peek] > arr[peek+1]) peek++;

            if(j > i && peek > j) {
                longestPath = Math.max(peek - i + 1, longestPath);
            }

            if(i != peek) {
                i = peek;
            }else {
                i++;
            }
        }

        return longestPath;
    }
    
    public static void main(String[] args) {
        LeetCode_845_LongestMountainInArray longestMountainInArray = new LeetCode_845_LongestMountainInArray();
        int[] arr = {0,2,0,2,1,2,3,4,4,1};
        System.out.println(longestMountainInArray.longestMountain(arr));
    }
}
