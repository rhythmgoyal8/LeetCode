import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}

public class mergeTrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values for first tree in level order (use -1 for null nodes):");
        TreeNode root1 = buildTree(scanner);
        
        System.out.println("Enter values for second tree in level order (use -1 for null nodes):");
        TreeNode root2 = buildTree(scanner);
        
        Solution solution = new Solution();
        TreeNode mergedRoot = solution.mergeTrees(root1, root2);
        
        System.out.println("Merged tree in level order:");
        System.out.println(printLevelOrder(mergedRoot));
        
        scanner.close();
    }
    
    public static TreeNode buildTree(Scanner scanner) {
        String[] values = scanner.nextLine().split(" ");
        if (values.length == 0 || values[0].equals("-1")) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        int i = 1;
        
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            
            if (!values[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.left);
            }
            i++;
            
            if (i < values.length && !values[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static List<Integer> printLevelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                result.add(current.val);
                queue.add(current.left);
                queue.add(current.right);
            } else {
                result.add(null);
            }
        }
        
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        
        return result;
    }
}