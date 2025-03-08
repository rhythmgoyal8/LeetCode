import java.util.Scanner;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minRecolor = k;
        int whiteCount = 0;
        
        // Count the number of 'W' in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        
        minRecolor = whiteCount;

        // Sliding window technique
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            minRecolor = Math.min(minRecolor, whiteCount);
        }

        return minRecolor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking user input
        System.out.print("Enter the blocks string (only 'B' and 'W'): ");
        String blocks = scanner.next();
        
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        
        // Creating an instance of the class and calling the method
        MinimumRecolorsToGetKConsecutiveBlackBlocks solution = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
        int result = solution.minimumRecolors(blocks, k);
        
        // Output the result
        System.out.println("Minimum recolors needed: " + result);
        
        // Close scanner
        scanner.close();
    }
}
