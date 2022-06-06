package Homework.Nam_Nguyen.Lesson16;

public class LeetCode_370_RangeAddition {

    boolean inBound(int index, int length) {
        return index >= 0 && index < length;
    }
    
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int startIndex = updates[i][0];
            int endIndex = updates[i][1];
            int addition = updates[i][2];
            if(inBound(startIndex, length)) {
                res[startIndex]+=addition;
            }
            if(inBound(endIndex + 1, length)) {
                res[endIndex + 1]-=addition;
            }
        }
        for (int i = 1; i < length; i++) {
            res[i] = res[i-1] + res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_370_RangeAddition prob = new LeetCode_370_RangeAddition();
        int length = 10;
        int[][] updates = {{2,4,6},{5,6,8},{1,9,-4}};
        System.out.println("res: "+prob.getModifiedArray(length, updates));
    }
}
