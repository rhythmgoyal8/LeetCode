import java.util.Scanner;

public class SingleNumber { // Class name must match the filename
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num; // XOR operation to find the unique number
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the elements (all numbers appear twice except one):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        SingleNumber solution = new SingleNumber();
        int result = solution.singleNumber1(nums);

        System.out.println("The single number is: " + result);
        
        scanner.close();
    }
}
