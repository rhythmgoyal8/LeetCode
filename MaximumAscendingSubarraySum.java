import java.util.*;

public class MaximumAscendingSubarraySum {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int maxsum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i]; 
            } else {
                sum = nums[i];
            }
            maxsum = Math.max(maxsum, sum);
        }
        
        return maxsum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        
        MaximumAscendingSubarraySum solution = new MaximumAscendingSubarraySum();
        System.out.println("Max Ascending Sum: " + solution.maxAscendingSum(nums));
    }
}