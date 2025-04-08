import java.util.Scanner;

class LCA {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();
        TreeNode root = null;
        
        System.out.println("Enter node values: ");
        for (int i = 0; i < n; i++) {
            root = insert(root, scanner.nextInt());
        }
        
        System.out.print("Enter first node value: ");
        int pVal = scanner.nextInt();
        System.out.print("Enter second node value: ");
        int qVal = scanner.nextInt();
        
        TreeNode p = findNode(root, pVal);
        TreeNode q = findNode(root, qVal);
        
        if (p == null || q == null) {
            System.out.println("One or both nodes not found in the tree.");
        } else {
            TreeNode lca = lowestCommonAncestor(root, p, q);
            System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "Not found"));
        }
        
        scanner.close();
    }
    
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }
    
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return val < root.val ? findNode(root.left, val) : findNode(root.right, val);
    }
}