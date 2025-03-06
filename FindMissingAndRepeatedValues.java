import java.util.*;

public class FindMissingAndRepeatedValues {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the matrix (n): ");
        int n = scanner.nextInt();

        int[][] grid = new int[n][n];

        System.out.println("Enter the elements of the " + n + "x" + n + " grid:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // Create an instance of the solution class and call the method
        FindMissingAndRepeatedValues solution = new FindMissingAndRepeatedValues();
        int[] result = solution.findMissingAndRepeatedValues(grid);

        // Output the result
        System.out.println("Repeated Value: " + result[0]);
        System.out.println("Missing Value: " + result[1]);

        scanner.close();
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] out = new int[2];
        int[] count = new int[n * n + 1];

        int repeated = -1, missing = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }
        for (int i = 1; i <= n * n; i++) {
            if (count[i] == 2) {
                repeated = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }

        out[0] = repeated;
        out[1] = missing;
        return out;
    }
}
