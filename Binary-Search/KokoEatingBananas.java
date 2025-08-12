import java.util.*;

public class KokoEatingBananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input piles
        System.out.print("Enter number of piles: ");
        int n = sc.nextInt();
        int[] piles = new int[n];
        System.out.print("Enter bananas in each pile: ");
        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        // Input hours
        System.out.print("Enter number of hours (h): ");
        int h = sc.nextInt();

        int result = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);

        sc.close();
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles[0];
        for (int pile : piles) {
            if (high < pile) {
                high = pile;
            }
        }

        int ans = high;
        while (low <= high) {
            long time = 0;
            int mid = low + (high - low) / 2;
            for (int pile : piles) {
                time += (pile + mid - 1) / mid; // ceiling division
            }
            if (time <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
