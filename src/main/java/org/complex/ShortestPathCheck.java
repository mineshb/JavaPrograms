package org.complex;

import java.util.*;

/**
    3. Check if given path between two nodes of a graph represents a shortest paths
    Given an unweighted directed graph and Q queries consisting of sequences of traversal between two nodes of the graph,
    the task is to find out if the sequences represent one of the shortest paths between the two nodes.
Examples:
    Input: 1 2 3 4
    Output: NO

    Input: 1 3 4
    Output: Yes
 */
public class ShortestPathCheck {

    public static void main(String[] args) {
        // Graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(4));
        graph.put(4, Arrays.asList(1));

        int startNode = 1;
        int endNode = 4;
        List<Integer> path = Arrays.asList(1, 2, 3, 4);

        boolean isShortest = isShortestPath(graph, startNode, endNode, path);
        System.out.println(path);
        System.out.println(isShortest ? "YES" : "NO");

        List<Integer> path2 = Arrays.asList(1, 2, 3, 4);
        isShortest = isShortestPath(graph, startNode, endNode, path2);
        System.out.println(path2);
        System.out.println(isShortest ? "YES" : "NO");
    }

    public static boolean isShortestPath(Map<Integer, List<Integer>> graph, int startNode, int endNode, List<Integer> path) {
        // Step 1: Perform BFS to find the shortest path distances from startNode
        Map<Integer, Integer> distance = bfsShortestPath(graph, startNode);

        // Step 2: Validate the given path
        for (int i = 0; i < path.size() - 1; i++) {
            int currentNode = path.get(i);
            int nextNode = path.get(i + 1);

            // Check if the next node is reachable and at the correct distance
            if (!graph.get(currentNode).contains(nextNode) || distance.get(nextNode) != distance.get(currentNode) + 1) {
                return false;
            }
        }

        // The path should end at the correct destination
        return path.get(path.size() - 1) == endNode;
    }

    public static Map<Integer, Integer> bfsShortestPath(Map<Integer, List<Integer>> graph, int startNode) {
        Map<Integer, Integer> distance = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        distance.put(startNode, 0);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int currentDistance = distance.get(currentNode);

            for (int neighbor : graph.get(currentNode)) {
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, currentDistance + 1);
                    queue.add(neighbor);
                }
            }
        }

        return distance;
    }
}
