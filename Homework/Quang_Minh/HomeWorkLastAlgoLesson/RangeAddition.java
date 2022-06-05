package HomeWorkLastAlgoLesson;

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int[] update : updates){
            int start = update[0];
            int end = update[1];
            int val = update[2];
            result[start] += val;
            if(end + 1 < length) result[end+1] -= val;
        }
        for (int i = 1; i < length ; i++){
            result[i] += result[i-1];
        }
        return result;
    }
}
