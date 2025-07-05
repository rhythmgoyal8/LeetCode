import java.util.*;

public class SingleElementInASortedArray {

    public static int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " sorted elements (all appear twice except one):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = singleNonDuplicate(nums);
        System.out.println("The single non-duplicate element is: " + result);

        sc.close();
    }
}
