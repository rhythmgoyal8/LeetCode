import java.util.Scanner;

public class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input pivot
        System.out.print("Enter the pivot: ");
        int pivot = sc.nextInt();

        // Process and output the result
        int[] result = pivotArray(nums, pivot);

        System.out.println("Array after partitioning:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int j = 0;

        // Add elements smaller than pivot
        for (int num : nums) {
            if (num < pivot) {
                result[j++] = num;
            }
        }

        // Add elements equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                result[j++] = num;
            }
        }

        // Add elements greater than pivot
        for (int num : nums) {
            if (num > pivot) {
                result[j++] = num;
            }
        }

        return result;
    }
}
