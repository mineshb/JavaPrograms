package org.complex;


import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

public class TravellingSalesMan {

    public static void main(String[] args) {
        // Example distance matrix for 4 cities
        int[][] distanceMatrix = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        // Number of cities
        int numCities = distanceMatrix.length;

        // Generate all possible permutations
        List<List<Integer>> permutations = generatePermutations(numCities);
        System.out.println("Permutations: " + permutations);

        // Find the shortest path
        List<Integer> bestRoute = null;
        int minDistance = Integer.MAX_VALUE;

        for (List<Integer> route : permutations) {
            int distance = calculateRouteDistance(route, distanceMatrix);
            //System.out.println("Route = " + route + ", distance = " + distance);
            if (distance < minDistance) {
                minDistance = distance;
                bestRoute = route;
            }
        }

        // Output the results
        System.out.println("Best Route: " + bestRoute);
        System.out.println("Minimum Distance: " + minDistance);
    }

    // Generate all permutations of cities
    private static List<List<Integer>> generatePermutations(int numCities) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> initial = new ArrayList<>();
        for (int i = 0; i < numCities; i++) {
            initial.add(i);
        }
        permute(initial, 0, permutations);
        return permutations;
    }

    // Recursive permutation generator
    private static void permute(List<Integer> list, int start, List<List<Integer>> permutations) {
        if (start == list.size() - 1) {
            permutations.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < list.size(); i++) {
                Collections.swap(list, start, i);
                permute(list, start + 1, permutations);
                Collections.swap(list, start, i); // backtrack
            }
        }
    }

    // Calculate the total distance of a given route
    private static int calculateRouteDistance(List<Integer> route, int[][] distanceMatrix) {
        int totalDistance = 0;
        int numCities = route.size();
        for (int i = 0; i < numCities - 1; i++) {
            totalDistance += distanceMatrix[route.get(i)][route.get(i + 1)];
        }
        // Return to starting city
        totalDistance += distanceMatrix[route.get(numCities - 1)][route.get(0)];
        return totalDistance;
    }
}
