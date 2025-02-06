import java.util.Scanner;

public class SpecialArrayI {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;
        boolean isEven = nums[0] % 2 == 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (isEven) {
                if (i % 2 == 0 && nums[i] % 2 != 0) return false;
                if (i % 2 != 0 && nums[i] % 2 == 0) return false;
            } else {
                if (i % 2 == 0 && nums[i] % 2 == 0) return false;
                if (i % 2 != 0 && nums[i] % 2 != 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        SpecialArrayI specialArray = new SpecialArrayI();
        boolean result = specialArray.isArraySpecial(nums);
        System.out.println("Is the array special? " + result);
        
        scanner.close();
    }
}
