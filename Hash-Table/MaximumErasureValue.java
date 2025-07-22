import java.util.*;

public class MaximumErasureValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = maximumUniqueSubarray(nums);
        System.out.println("Maximum Erasure Value: " + result);

        sc.close();
    }

    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int left = 0, right = 0;
        int currSum = 0, maxSum = 0;

        while (right < nums.length) {
            if (!seen.contains(nums[right])) {
                seen.add(nums[right]);
                currSum += nums[right];
                maxSum = Math.max(maxSum, currSum);
                right++;
            } else {
                seen.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
