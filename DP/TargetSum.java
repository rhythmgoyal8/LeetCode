import java.util.Scanner;

public class TargetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input target
        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        // Compute and print result
        int result = findTargetSumWays(nums, target);
        System.out.println("Number of ways to reach target sum: " + result);
        sc.close();
    }

    public static int findTargetSumWays(int[] nums, int target) {
        return rec(nums, 0, 0, target); 
    }

    private static int rec(int[] nums, int i, int val, int target) {
        if (i >= nums.length && val == target) return 1;
        if (i >= nums.length) return 0;

        int plus = rec(nums, i + 1, val + nums[i], target);
        int minus = rec(nums, i + 1, val - nums[i], target);

        return plus + minus;
    }
}
