import java.util.*;

class Count_Server {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowcount = new int[m];
        int[] colcount = new int[n];

        // Count servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowcount[i]++;
                    colcount[j]++;
                }
            }
        }

        int count = 0;
        // Check if the server can communicate
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (rowcount[i] > 1 || colcount[j] > 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows:- ");
        int m = scanner.nextInt();

        System.out.print("Enter the number of columns:- ");
        int n = scanner.nextInt();

        int[][] grid = new int[m][n];
        System.out.println("Enter the grid values (0 or 1):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        Count_Server countServer = new Count_Server();
        int result = countServer.countServers(grid);
        System.out.println("Number of servers that can communicate: " + result);

        scanner.close();
    }
}
