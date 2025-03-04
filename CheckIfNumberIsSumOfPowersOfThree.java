import java.util.*;

public class CheckIfNumberIsSumOfPowersOfThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        if (checkPowersOfThree(n)) {
            System.out.println(n + " can be represented as a sum of distinct powers of three.");
        } else {
            System.out.println(n + " cannot be represented as a sum of distinct powers of three.");
        }
    }

    public static boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
