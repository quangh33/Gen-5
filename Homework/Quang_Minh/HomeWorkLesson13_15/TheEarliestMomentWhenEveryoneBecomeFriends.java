package HomeWorkLesson13_15;

import java.util.Arrays;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    public static int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs,(a, b) -> a[0] - b[0]);
        DisjointSetUpdateSize disjointSet = new DisjointSetUpdateSize(n);
        int lastTime = -1;
        int numOfComponents = n;
        for (int[] currentLog : logs) {
            boolean canUnion = disjointSet.union(currentLog[1], currentLog[2]);
            if (canUnion) {
                lastTime = currentLog[0];
                numOfComponents --;
            }
            if (numOfComponents == 1) break;
        }

        return numOfComponents == 1 ? lastTime : -1;
    }


    public static void main(String[] args) {

    }
}
