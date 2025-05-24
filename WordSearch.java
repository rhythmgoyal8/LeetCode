import java.util.Scanner;

public class WordSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input board dimensions
        System.out.print("Enter number of rows: ");
        int m = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int n = scanner.nextInt();

        char[][] board = new char[m][n];

        // Input board characters
        System.out.println("Enter the board characters row by row:");
        for (int i = 0; i < m; i++) {
            String row = scanner.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        // Input word to search
        System.out.print("Enter the word to search: ");
        String word = scanner.next();

        // Create instance and check existence
        WordSearch solution = new WordSearch();
        boolean exists = solution.exist(board, word);

        // Output result
        if (exists) {
            System.out.println("Word exists in the board.");
        } else {
            System.out.println("Word does not exist in the board.");
        }

        scanner.close();
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean result = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result) return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
            visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
            backtrack(board, word, visited, i - 1, j, index + 1) ||
            backtrack(board, word, visited, i, j + 1, index + 1) ||
            backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}



// Enter number of rows: 3
// Enter number of columns: 4
// Enter the board characters row by row:
// ABCD
// SFCS
// ADEE
// Enter the word to search: ABCCED