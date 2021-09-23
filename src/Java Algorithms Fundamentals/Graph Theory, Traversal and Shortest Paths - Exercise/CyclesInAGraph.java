package GraphTheoryTraversalAndShortestPaths;

import java.util.*;
import java.util.stream.Collectors;

public class CyclesInAGraph {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> graph = new LinkedHashMap<>();

        String vertex = scan.nextLine();

        while (!vertex.equals("End")) {

            List<String> input = Arrays.stream(vertex.split("-"))
                    .collect(Collectors.toList());

            String key = input.remove(0);

            graph.putIfAbsent(key, new ArrayList<>());
            graph.get(key).addAll(input);

            vertex = scan.nextLine();
        }

        Map<String, Integer> countDependencies = countDependencies(graph);

        while (!graph.isEmpty()) {

            String node = graph.keySet().stream()
                    .filter(e -> countDependencies.get(e) == 0)
                    .findFirst()
                    .orElse(null);

            if (node == null) {

                System.out.println("Acyclic: No");
                return;
            }

            for (String nodes : graph.get(node)) {

                if (countDependencies.containsKey(nodes)) {
                    countDependencies.put(nodes, countDependencies.get(nodes) - 1);
                }
            }

            graph.remove(node);
            countDependencies.remove(node);

        }

        System.out.println("Acyclic: Yes");
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
}
