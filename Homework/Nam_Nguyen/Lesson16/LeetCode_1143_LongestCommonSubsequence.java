package Homework.Nam_Nguyen.Lesson16;

public class LeetCode_1143_LongestCommonSubsequence {
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] f = new int[n+1][m+1];
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    f[i][j] = f[i-1][j-1] + 1;
                }else {
                    f[i][j] = Math.max(f[i][j-1], f[i-1][j]);
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        LeetCode_1143_LongestCommonSubsequence prob = new LeetCode_1143_LongestCommonSubsequence();
        String text1 = "abc", text2 = "def";
        System.out.println("res: "+prob.longestCommonSubsequence(text1, text2));
    }
}
