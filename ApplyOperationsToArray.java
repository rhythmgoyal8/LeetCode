import java.util.Scanner;

public class ApplyOperationsToArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        // Taking input for array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Apply operations
        applyOperations(nums);

        // Printing the result
        System.out.println("Resultant array after applying operations:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    public static void applyOperations(int[] nums) {
        int n = nums.length;

        // Step 1: Perform operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Move nonzero elements forward
        int j = 0;  // Pointer for placing nonzero elements
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        // Step 3: Fill remaining positions with zeroes
        while (j < n) {
            nums[j++] = 0;
        }
    }
}
