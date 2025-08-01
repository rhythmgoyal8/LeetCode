import java.util.*;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return rec(text1, text2, 0, 0, dp);
    }

    private int rec(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + rec(s1, s2, i + 1, j + 1, dp);
        } else {
            int skipS1 = rec(s1, s2, i + 1, j, dp);
            int skipS2 = rec(s1, s2, i, j + 1, dp);
            dp[i][j] = Math.max(skipS1, skipS2);
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string:");
        String text1 = sc.nextLine();
        System.out.println("Enter second string:");
        String text2 = sc.nextLine();

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int result = lcs.longestCommonSubsequence(text1, text2);
        System.out.println("Length of Longest Common Subsequence: " + result);
    }
}
