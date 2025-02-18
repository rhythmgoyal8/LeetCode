import java.util.*;

class BuyTwoChocolates {
    public int buyChoco(int[] prices, int money) {
        int n = prices.length;
        Arrays.sort(prices); // Sort the prices array to get the two smallest chocolates
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int totalCost = prices[i] + prices[j];
                if (totalCost <= money) {
                    return (money - totalCost); // Return remaining money after buying chocolates
                }
            }
        }
        return money; // If no valid pair is found, return the full money
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of chocolate prices
        System.out.println("Enter the number of chocolates:");
        int n = scanner.nextInt();
        
        // Read the chocolate prices
        int[] prices = new int[n];
        System.out.println("Enter the prices of chocolates:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        
        // Read the available money
        System.out.println("Enter the amount of money available:");
        int money = scanner.nextInt();
        
        // Create an object of BuyTwoChocolates and call the buyChoco method
        BuyTwoChocolates solution = new BuyTwoChocolates();
        int remainingMoney = solution.buyChoco(prices, money);
        
        // Output the remaining money after buying the two chocolates
        System.out.println("Remaining money: " + remainingMoney);
        
        // Close the scanner
        scanner.close();
    }
}
