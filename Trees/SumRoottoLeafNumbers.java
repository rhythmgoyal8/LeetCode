import java.util.*;

public class SumRoottoLeafNumbers {

    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to calculate sum from root to leaf
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int currentNumber) {
        if (node == null) return 0;

        currentNumber = currentNumber * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        return dfs(node.left, currentNumber) + dfs(node.right, currentNumber);
    }

    // Build tree from level-order array input like [4,9,0,5,1]
    public static TreeNode buildTreeFromList(List<String> nodes) {
        if (nodes.isEmpty() || nodes.get(0).equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < nodes.size()) {
            TreeNode current = queue.poll();

            // Left child
            if (i < nodes.size() && !nodes.get(i).equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes.get(i)));
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < nodes.size() && !nodes.get(i).equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes.get(i)));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tree as level order (e.g., 4,9,0,5,1):");
        String input = sc.nextLine();

        // Remove brackets if user includes them: [4,9,0,5,1]
        input = input.replace("[", "").replace("]", "").trim();

        // Split and parse input
        List<String> nodes = Arrays.asList(input.split(","));

        TreeNode root = buildTreeFromList(nodes);
        int result = sumNumbers(root);
        System.out.println("Sum of Root to Leaf Numbers: " + result);
    }
}
