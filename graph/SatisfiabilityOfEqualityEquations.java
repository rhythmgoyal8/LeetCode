import java.util.*;

public class SatisfiabilityOfEqualityEquations {
    int[] par = new int[26];

    int find(int x) {
        if (par[x] != x) {
            par[x] = find(par[x]);
        }
        return par[x];
    }

    void union(int x, int z) {
        int parent_x = find(x);
        int parent_z = find(z);
        par[parent_x] = parent_z;
    }

    public boolean equationsPossible(String[] equations) {
        // Initialize parent array
        for (int i = 0; i < 26; i++) {
            par[i] = i;
        }

        // First pass: handle equalities
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';
                union(a, b);
            }
        }

        // Second pass: handle inequalities
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';
                if (find(a) == find(b)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of equations: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] equations = new String[n];
        System.out.println("Enter equations (format: a==b or a!=b):");
        for (int i = 0; i < n; i++) {
            equations[i] = sc.nextLine();
        }

        SatisfiabilityOfEqualityEquations solver = new SatisfiabilityOfEqualityEquations();
        boolean result = solver.equationsPossible(equations);

        if (result) {
            System.out.println("All equations are satisfiable.");
        } else {
            System.out.println("Equations are not satisfiable.");
        }
    }
}
