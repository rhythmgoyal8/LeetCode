import java.util.*;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int result = solution.firstMissingPositive(nums);

        System.out.println("The first missing positive integer is: " + result);

        scanner.close();
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int a = 1;
        while (set.contains(a)) {
            a++;
        }
        return a;
    }
}
