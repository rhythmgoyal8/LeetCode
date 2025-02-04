import java.util.*;

public class AddDigits {
    public int addDigits(int num) {
        int sum = 0;
        while (num != 0) {
            int rem = num % 10;
            sum += rem;
            num = num / 10;
        }
        while (sum >= 10) {
            int sum1 = 0;
            while (sum != 0) {
                int rem = sum % 10;
                sum1 += rem;
                sum = sum / 10;
            }
            sum = sum1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();
        
        AddDigits solution = new AddDigits();

        int result = solution.addDigits(num);
        System.out.println("The single-digit sum is: " + result);
        scanner.close();
    }
}
