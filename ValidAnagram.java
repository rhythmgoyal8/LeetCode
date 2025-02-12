import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s = scanner.nextLine();
        System.out.print("Enter second string: ");
        String t = scanner.nextLine();
        scanner.close();
        
        System.out.println("Are the strings anagrams? " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }
}
