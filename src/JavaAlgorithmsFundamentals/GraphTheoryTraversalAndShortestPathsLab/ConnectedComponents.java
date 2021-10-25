package JavaAlgorithmsFundamentals.GraphTheoryTraversalAndShortestPathsLab;

import java.util.*;
import java.util.stream.Collectors;

public class ConnectedComponents {

    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<List<Integer>> graph = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String line = scan.nextLine();

            if (line.isEmpty()) {

                graph.add(new ArrayList<>());
                continue;
            }

            List<Integer> edges = Arrays.stream(line.split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            graph.add(edges);
        }

        visited = new boolean[graph.size()];
        List<Deque<Integer>> components = getComponents(graph);

        for (int i = 0; i < components.size(); i++) {

            System.out.print("Connected components: ");

            while (!components.get(i).isEmpty()) {

                System.out.print(components.get(i).poll() + " ");
            }

            System.out.println();
        }
    }

    public static List<Deque<Integer>> getComponents(List<List<Integer>> graph) {

        List<Deque<Integer>> connectedComponents = new ArrayList<>();

        for (int startNode = 0; startNode < graph.size(); startNode++) {

            if (!visited[startNode]) {

                connectedComponents.add(new ArrayDeque<>());
                // bfs(graph, i, connectedComponents);
                dfs(graph, startNode, connectedComponents);
            }
        }

        return connectedComponents;
    }

    public static void bfs(List<List<Integer>> graph, int start, List<Deque<Integer>> connectedComponents) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(start);
        visited[start] = true;

        while (!deque.isEmpty()) {

            int node = deque.poll();

            connectedComponents.get(connectedComponents.size() - 1).offer(node);

            for (int nodes : graph.get(node)) {

                if (!visited[nodes]) {

                    visited[nodes] = true;
                    deque.offer(nodes);
                }
            }
        }
    }

    public static void dfs(List<List<Integer>> graph, int start, List<Deque<Integer>> connectedComponents) {

        if (!visited[start]) {

            visited[start] = true;

            for (int child : graph.get(start)) {

                dfs(graph, child, connectedComponents);
            }
            connectedComponents.get(connectedComponents.size() - 1).offer(start);
        }

    }
}

