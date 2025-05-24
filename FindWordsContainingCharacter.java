import java.util.*;

public class FindWordsContainingCharacter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of words
        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume the newline

        String[] words = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        // Take the character input
        System.out.print("Enter the character to search: ");
        char x = sc.next().charAt(0);

        // Call method and print result
        Solution sol = new Solution();
        List<Integer> result = sol.findWordsContaining(words, x);

        System.out.println("Indices of words containing '" + x + "': " + result);
    }
}

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> arr = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == x) {
                    arr.add(i);
                    break;
                }
            }
        }
        return arr;
    }
}
