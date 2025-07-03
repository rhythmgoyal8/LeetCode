import java.util.Scanner;

public class FindTheKthCharacterInStringGameI {

    static class Solution {
        public char kthCharacter(int k) {
            StringBuilder sb = new StringBuilder("a");
            while (sb.length() < k) {
                int len = sb.length();
                for (int i = 0; i < len && sb.length() < k; i++) {
                    char ch = sb.charAt(i);
                    char next = (char)((ch - 'a' + 1) % 26 + 'a');
                    sb.append(next);
                }
            }
            return sb.charAt(k - 1); // zero-based indexing
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        Solution sol = new Solution();
        char result = sol.kthCharacter(k);
        System.out.println("The " + k + "-th character is: " + result);

        scanner.close();
    }
}
