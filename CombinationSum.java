import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of candidates:");
        int n = sc.nextInt();
        int[] candidates = new int[n];

        System.out.print("Enter candidates:");
        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        System.out.print("Enter target:");
        int target = sc.nextInt();

        System.out.print("Combinations are:");
        findCombinations(candidates, target);

        sc.close();
    }

    public static void findCombinations(int[] candidates, int target) {
        List<Integer> ans = new ArrayList<>();
        backtrack(candidates, target, ans, 0);
    }

    public static void backtrack(int[] arr, int target, List<Integer> ans, int i) {
        if (target == 0) {
            System.out.println(ans);
            return;
        }
        if (i >= arr.length || target < 0) return;

        // Include arr[i]
        ans.add(arr[i]);
        backtrack(arr, target - arr[i], ans, i);
        ans.remove(ans.size() - 1);

        // Exclude arr[i] and move to next
        backtrack(arr, target, ans, i + 1);
    }
}
