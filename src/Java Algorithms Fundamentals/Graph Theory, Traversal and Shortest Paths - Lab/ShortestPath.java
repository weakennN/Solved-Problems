package GraphTheoryTraversalAndShortestPaths;

import java.util.*;

public class ShortestPath {

    public static boolean[] visited;
    public static int[] helper;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {

            graph.add(new ArrayList<>());
        }

        int edges = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < edges; i++) {

            int[] paths = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph.get(paths[0]).add(paths[1]);
        }

        visited = new boolean[n + 1];
        helper = new int[n + 1];

        Arrays.fill(helper, -1);

        int start = Integer.parseInt(scan.nextLine());
        int destination = Integer.parseInt(scan.nextLine());

        bfs(start, destination, graph);

        path.add(destination);

        int prevNode = helper[destination];

        while (prevNode != -1) {

            path.add(prevNode);
            prevNode = helper[prevNode];
        }

        System.out.println("Shortest path length is: " + (path.size() - 1));

        for (int i = path.size() - 1;i >= 0;i--){

            System.out.print(path.get(i) + " ");
        }
    }

    public static void bfs(int start, int destination, List<List<Integer>> graph) {

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            if (node == destination) {

                return;
            }

            for (int child : graph.get(node)) {

                if (!visited[child]) {

                    visited[child] = true;
                    helper[child] = node;
                    queue.offer(child);
                }
            }
        }
    }
}
