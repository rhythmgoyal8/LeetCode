import java.util.*;

public class SortedAndRotated {
    public static boolean check(int[] nums) {
        int n = nums.length;
        int countDecreasing = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                countDecreasing++;
            }
            if (countDecreasing > 1) {
                return false;
            }
        }
        return true;
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
        System.out.println("Is the array sorted and rotated? " + check(nums));
    }
}
