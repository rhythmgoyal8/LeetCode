import java.util.Scanner;

public class Unique_Path_1 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return rec(0, 0, m, n, dp);
    }

    public int rec(int i, int j, int m, int n, int[][] dp) {
        if (i >= m || j >= n) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int down = rec(i + 1, j, m, n, dp);
        int right = rec(i, j + 1, m, n, dp);
        return dp[i][j] = down + right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows (m): ");
        int m = sc.nextInt();
        System.out.print("Enter columns (n): ");
        int n = sc.nextInt();

        Unique_Path_1 obj = new Unique_Path_1();
        int result = obj.uniquePaths(m, n);
        System.out.println("Number of unique paths: " + result);

        sc.close();
    }
}
