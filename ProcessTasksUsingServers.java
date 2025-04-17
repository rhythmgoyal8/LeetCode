import java.util.*;

public class ProcessTasksUsingServers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read servers
        System.out.print("Enter number of servers: ");
        int n = scanner.nextInt();
        int[] servers = new int[n];
        System.out.println("Enter server weights:");
        for (int i = 0; i < n; i++) {
            servers[i] = scanner.nextInt();
        }

        // Read tasks
        System.out.print("Enter number of tasks: ");
        int m = scanner.nextInt();
        int[] tasks = new int[m];
        System.out.println("Enter task durations:");
        for (int i = 0; i < m; i++) {
            tasks[i] = scanner.nextInt();
        }

        // Call assignTasks
        int[] result = assignTasks(servers, tasks);

        // Print result
        System.out.println("Assigned server indices:");
        System.out.println(Arrays.toString(result));
    }

    public static int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]); // [weight, index]
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : (a[1] != b[1] ? a[1] - b[1] : a[2] - b[2])); // [availableTime, weight, index]

        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        int time = 0;
        for (int i = 0; i < m; i++) {
            time = Math.max(time, i);

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] server = busy.poll();
                available.offer(new int[]{server[1], server[2]});
            }

            if (available.isEmpty()) {
                time = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    int[] server = busy.poll();
                    available.offer(new int[]{server[1], server[2]});
                }
            }

            int[] server = available.poll();
            ans[i] = server[1];
            busy.offer(new int[]{time + tasks[i], server[0], server[1]});
        }

        return ans;
    }
}
