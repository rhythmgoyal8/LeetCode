import java.util.*;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        int result = obj.findKthLargest(nums, k);
        System.out.println("Kth largest element is: " + result);

        sc.close();
    }
}
