import java.util.Scanner;

public class Unique_Path_2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return rec(0, 0, m, n, obstacleGrid, dp);
    }

    public int rec(int i, int j, int m, int n, int[][] obstacleGrid, int[][] dp) {
        if (i >= m || j >= n) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        int down = rec(i + 1, j, m, n, obstacleGrid, dp);
        int right = rec(i, j + 1, m, n, obstacleGrid, dp);

        return dp[i][j] = down + right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows (m): ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns (n): ");
        int n = sc.nextInt();

        int[][] obstacleGrid = new int[m][n];
        System.out.println("Enter obstacle grid (0 = empty, 1 = obstacle):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacleGrid[i][j] = sc.nextInt();
            }
        }

        Unique_Path_2 obj = new Unique_Path_2();
        int result = obj.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Number of unique paths (with obstacles): " + result);

        sc.close();
    }
}

