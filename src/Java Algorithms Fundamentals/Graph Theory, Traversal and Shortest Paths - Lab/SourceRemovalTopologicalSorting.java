package GraphTheoryTraversalAndShortestPaths;

import java.util.*;

public class SourceRemovalTopologicalSorting {

    public static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {

        Map<String, List<String>> graph = new LinkedHashMap<>();

       /* graph.put("IDEs", List.of("variables", "loops"));
        graph.put("loops", List.of("bits"));
        graph.put("conditionals", List.of("loops"));
        graph.put("variables", List.of("conditionals", "loops", "bits"));
        graph.put("bits", new ArrayList<>());

        */

        graph.put("A", List.of("F"));
        graph.put("F", List.of("D"));
        graph.put("D", List.of("A"));

        Map<String, Integer> countDependencies = countDependencies(graph);
        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()) {

            String nodeWithoutDependencies = countDependencies.keySet().stream()
                    .filter(e -> countDependencies.get(e) <= 0)
                    .findFirst()
                    .orElse(null);

            if (nodeWithoutDependencies == null) {

                break;
            }

            for (String nodes : graph.get(nodeWithoutDependencies)) {

                if (countDependencies.containsKey(nodes)) {
                    countDependencies.put(nodes, countDependencies.get(nodes) - 1);
                }
            }

            countDependencies.remove(nodeWithoutDependencies);
            sorted.add(nodeWithoutDependencies);
            graph.remove(nodeWithoutDependencies);
        }

        if (!graph.isEmpty()){

            System.out.println("theres is a cycle");
            return;
        }

        for (int i = 0; i < sorted.size(); i++) {

            System.out.print(sorted.get(i) + " ");
        }

    }

    public static Map<String, Integer> countDependencies(Map<String, List<String>> graph) {

        Map<String, Integer> countDependencies = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {

            countDependencies.putIfAbsent(entry.getKey(), 0);
            for (String child : entry.getValue()) {

                countDependencies.putIfAbsent(child, 0);
                countDependencies.put(child, countDependencies.get(child) + 1);
            }
        }

        return countDependencies;
    }

    public static void bfs(String vertex, Map<String, List<String>> graph, Map<String, Integer> countDependencies) {

        Deque<String> queue = new ArrayDeque<>();
        visited.add(vertex);

        queue.offer(vertex);

        while (!queue.isEmpty()) {

            String node = queue.poll();

            visited.add(node);
            countDependencies.putIfAbsent(node, 0);

            for (String nodes : graph.get(node)) {

                if (!visited.contains(nodes)) {

                    countDependencies.putIfAbsent(nodes, 0);
                    countDependencies.put(nodes, countDependencies.get(nodes) + 1);
                    queue.offer(nodes);
                }
            }
        }

    }
}
