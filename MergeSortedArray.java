import java.util.*;

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        for (int i = 0; i < m; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            nums[m + i] = nums2[i];
        }
        Arrays.sort(nums);
        for (int i = 0; i < m + n; i++) {
            nums1[i] = nums[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of nums1: ");
        int m = scanner.nextInt();
        System.out.print("Enter size of nums2: ");
        int n = scanner.nextInt();
        
        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];
        
        System.out.println("Enter elements of nums1:");
        for (int i = 0; i < m; i++) {
            nums1[i] = scanner.nextInt();
        }
        
        System.out.println("Enter elements of nums2:");
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }
        
        MergeSortedArray solution = new MergeSortedArray();
        solution.merge(nums1, m, nums2, n);
        
        System.out.println("Merged sorted array:");
        System.out.println(Arrays.toString(nums1));
        
        scanner.close();
    }
}
