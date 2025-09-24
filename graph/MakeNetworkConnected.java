import java.util.*;

public class MakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] conn : connections) {
            graph.get(conn[0]).add(conn[1]);
            graph.get(conn[1]).add(conn[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }
        }
        return components - 1;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of computers (n): ");
        int n = sc.nextInt();

        System.out.print("Enter number of connections: ");
        int m = sc.nextInt();

        int[][] connections = new int[m][2];
        System.out.println("Enter the connections (two integers per connection):");
        for (int i = 0; i < m; i++) {
            connections[i][0] = sc.nextInt();
            connections[i][1] = sc.nextInt();
        }

        MakeNetworkConnected solver = new MakeNetworkConnected();
        int result = solver.makeConnected(n, connections);

        if (result == -1) {
            System.out.println("Not enough cables to connect all computers.");
        } else {
            System.out.println("Minimum number of operations required: " + result);
        }
    }
}
