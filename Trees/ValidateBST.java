import java.util.*;

class ValidateBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }
    
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public static TreeNode insertLevelOrder(Integer[] arr, int i) {
        if (i >= arr.length || arr[i] == null) return null;
        TreeNode root = new TreeNode(arr[i]);
        root.left = insertLevelOrder(arr, 2 * i + 1);
        root.right = insertLevelOrder(arr, 2 * i + 2);
        return root;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        System.out.println("Enter the node values (use -1 for null):");
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            arr[i] = (val == -1) ? null : val;
        }
        
        TreeNode root = insertLevelOrder(arr, 0);
        ValidateBST validateBST = new ValidateBST();
        boolean isBST = validateBST.isValidBST(root);
        System.out.println("Is the given tree a valid BST? " + isBST);
        
        scanner.close();
    }
}
