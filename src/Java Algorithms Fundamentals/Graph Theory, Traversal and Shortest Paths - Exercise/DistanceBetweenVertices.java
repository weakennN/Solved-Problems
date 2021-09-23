package GraphTheoryTraversalAndShortestPaths;

import java.util.*;
import java.util.stream.Collectors;

public class DistanceBetweenVertices {

    public static Set<Integer> visited = new HashSet<>();
    public static int counter = 0;
    public static Map<String, String> helper = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
        List<String> shortestPath = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());
        int p = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            List<Integer> edges = Arrays.stream(scan.nextLine().split("[: ]+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int key = edges.remove(0);
            graph.putIfAbsent(key, new ArrayList<>());

            if (edges.size() < 1) {
                continue;
            }

            graph.get(key).addAll(edges);
        }

        for (int i = 0; i < p; i++) {

            int[] toFind = Arrays.stream(scan.nextLine().split("[-]"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int start = toFind[0];
            int destination = toFind[1];

            int count = bfs(start, destination, graph);

            if (count == -1) {

                print(start, destination, -1);
                visited = new HashSet<>();
                helper = new LinkedHashMap<>();
                continue;
            }

            String prevNode = helper.get(String.valueOf(destination));

            while (prevNode != null) {

                shortestPath.add(prevNode);
                prevNode = helper.get(prevNode);
            }

            print(start, destination, shortestPath.size());

            shortestPath.clear();
            visited.clear();
            helper.clear();

            count = 0;
        }
    }

    public static int bfs(int start, int destination, Map<Integer, List<Integer>> graph) {

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            int node = queue.poll();

            if (node == destination) {

                return counter;
            }

            counter++;

            for (int child : graph.get(node)) {

                if (!visited.contains(child)) {

                    visited.add(child);
                    helper.put(String.valueOf(child), String.valueOf(node));
                    queue.offer(child);
                }
            }
        }

        return -1;
    }

    public static void print(int start, int destination, int distance) {

        System.out.printf("{%d, %d} -> %d%n", start, destination, distance);
    }
}
