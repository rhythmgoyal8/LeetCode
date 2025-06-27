import java.util.*;

public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 3] * nums[n - 2] * nums[n - 1],
                        nums[0] * nums[1] * nums[n - 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        MaximumProductOfThreeNumbers obj = new MaximumProductOfThreeNumbers();
        int result = obj.maximumProduct(nums);
        System.out.println("Maximum product of any three numbers: " + result);
    }
}
