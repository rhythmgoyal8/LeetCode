import java.util.*;

public class UniqueBST {
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return rec(n, dp);
    }

    public static int rec(int n, int[] dp) {
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += rec(i - 1, dp) * rec(n - i, dp);
        }
        return dp[n] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // input for number of nodes
        System.out.println(numTrees(n));
        sc.close();
    }
}
