import java.util.*;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long a = (dividend / divisor);
        return (int) a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter dividend: ");
        int dividend = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        DivideTwoIntegers solver = new DivideTwoIntegers();
        int result = solver.divide(dividend, divisor);

        System.out.println("Result of division: " + result);

        sc.close();
    }
}
