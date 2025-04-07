import java.util.*;

public class MaximumPathSum {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftMax = Math.max(0, dfs(node.left));  
        int rightMax = Math.max(0, dfs(node.right));

        int currentMax = leftMax + rightMax + node.val;
        maxSum = Math.max(maxSum, currentMax);

        return Math.max(leftMax, rightMax) + node.val;
    }

    // Method to build the tree from level-order input
    public static TreeNode buildTree(Scanner scanner) {
        System.out.println("Enter values in level order (use 'null' for empty nodes):");
        String[] values = scanner.nextLine().split(" ");
        if (values.length == 0 || values[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();
            if (!values[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.left);
            }
            i++;

            if (i < values.length && !values[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = buildTree(scanner);
        scanner.close();

        MaximumPathSum solution = new MaximumPathSum();
        System.out.println("Maximum Path Sum: " + solution.maxPathSum(root));
    }
}
