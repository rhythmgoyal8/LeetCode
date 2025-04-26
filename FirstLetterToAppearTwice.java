import java.util.*;

public class FirstLetterToAppearTwice {

    public char repeatedCharacter(String s) {
        HashSet<Character> set = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return c;
            }
            set.add(c);
        }
        
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        FirstLetterToAppearTwice solution = new FirstLetterToAppearTwice();
        char result = solution.repeatedCharacter(input);

        if (result != '\0') {
            System.out.println("First letter to appear twice: " + result);
        } else {
            System.out.println("No letter appears twice.");
        }

        scanner.close();
    }
}
