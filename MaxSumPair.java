import java.util.*;

class MaxSumPair {

    // Function to calculate the sum of digits of a number
    public static int sum(int n) {
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum += rem;
            n /= 10;
        }
        return sum;
    }

    // Function to find the maximum sum of a pair with the same sum of digits
    public static int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxsum = -1;

        // Loop over each number in the array
        for (int i = 0; i < nums.length; i++) {
            int digitSum = sum(nums[i]);

            // If we find a number with the same digit sum
            if (map.containsKey(digitSum)) {
                int prevNum = map.get(digitSum);
                // Update maxsum with the larger sum of the current pair
                maxsum = Math.max(maxsum, prevNum + nums[i]);
                // Update the map with the larger number for the same sum of digits
                map.put(digitSum, Math.max(prevNum, nums[i]));
            } else {
                // If no number with the same sum of digits exists, add it to the map
                map.put(digitSum, nums[i]);
            }
        }

        return maxsum;  // Return the largest sum found, or -1 if no valid pair was found
    }

    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Create an array to store the numbers
        int[] nums = new int[n];

        // Read the elements into the array
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Call maximumSum function to find the result
        int result = maximumSum(nums);

        // Print the result
        System.out.println("Maximum sum of a pair with the same sum of digits: " + result);

        // Close the scanner
        scanner.close();
    }
}
