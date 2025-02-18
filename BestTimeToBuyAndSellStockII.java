import java.util.*;

public class BestTimeToBuyAndSellStockII {
    
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int totalProfit = 0;
        
        // Traverse through the prices array
        for (int i = 1; i < prices.length; i++) {
            int buy = prices[i - 1]; 
            int profit = 0;
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buy);
            }
            totalProfit += profit;
        }
        
        return totalProfit;
    }

    public static void main(String[] args) {
        // Create Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Input number of days
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        
        // Input the stock prices
        int[] prices = new int[n];
        System.out.print("Enter stock prices for " + n + " days: ");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        // Call maxProfit function and output the result
        int result = maxProfit(prices);
        System.out.println("Maximum profit: " + result);
        
        // Close the scanner
        sc.close();
    }
}
