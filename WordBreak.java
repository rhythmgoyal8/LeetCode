import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking the string input
        System.out.print("Enter the string: ");
        String s = sc.nextLine();
        
        // Taking the dictionary input
        System.out.print("Enter number of words in dictionary: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline
        
        List<String> wordDict = new ArrayList<>();
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            wordDict.add(sc.nextLine());
        }
        
        // Calling the function and printing result
        boolean result = wordBreak(s, wordDict);
        System.out.println("Can the string be segmented? " + result);
        
        sc.close();
    }
}
