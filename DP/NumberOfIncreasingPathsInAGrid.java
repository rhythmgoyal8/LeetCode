import java.util.*;

public class NumberOfIncreasingPathsInAGrid {
    public static int mod = 1000000007;

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + rec(i, j, grid, dp, -1)) % mod;
            }
        }
        return ans;
    }

    public int rec(int i, int j, int[][] matrix, int[][] dp, int prev) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        if (matrix[i][j] <= prev) return 0;
        if (dp[i][j] != 0) return dp[i][j];

        int best = 1; // path of length 1 (itself)

        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];
            best = (best + rec(row, col, matrix, dp, matrix[i][j])) % mod;
        }
        dp[i][j] = best;
        return best;
    }

    // Main function with Scanner
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows (m): ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns (n): ");
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        System.out.println("Enter grid values:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        NumberOfIncreasingPathsInAGrid sol = new NumberOfIncreasingPathsInAGrid();
        int result = sol.countPaths(grid);

        System.out.println("Number of Increasing Paths in a Grid: " + result);

        sc.close();
    }
}
