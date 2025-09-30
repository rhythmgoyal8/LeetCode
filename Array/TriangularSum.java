import java.util.Scanner;

public class TriangularSum {

    public static int triangularSum(int[] nums) {
        int n = nums.length;

        for (int size = n; size > 1; size--) {
            for (int i = 0; i < size - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: size of array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = triangularSum(nums);
        System.out.println("Triangular Sum = " + result);

        sc.close();
    }
}


    
