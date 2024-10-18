package org.complex;
import java.util.*;

/**
        * Instructions to candidate.
        * 1) Run this code in the REPL to observe its behaviour. The
        * execution entry point is main().
        * 2) Consider adding some additional tests in doTestsPass().
        * 3) Implement def shortestPath(self, fromStationName, toStationName)
        * method to find shortest path between 2 stations
        * 4) If time permits, some possible follow-ups.
        *

         *      Visual representation of the Train map used
         *
         *      King's Cross St Pancras --- Angel ---- Old Street
         *      |                   \                            |
         *      |                    \                            |
         *      |                     \                            |
         *      Russell Square         Farringdon --- Barbican --- Moorgate
         *      |                                                  /
         *      |                                                 /
         *      |                                                /
         *      Holborn --- Chancery Lane --- St Paul's --- Bank
         *
*/

public class TrainStationShortestPath {

    // Adjacency list to represent the graph
    private Map<String, List<String>> stations = new HashMap<>();

    // Method to add connections between stations
    public void addStation(String station1, String station2) {
        stations.computeIfAbsent(station1, k -> new ArrayList<>()).add(station2);
        stations.computeIfAbsent(station2, k -> new ArrayList<>()).add(station1);
    }

    // Method to find the shortest path between two stations using BFS
    public List<String> shortestPath(String fromStationName, String toStationName) {
        if (fromStationName.equals(toStationName)) {
            return Arrays.asList(fromStationName);
        }

        // BFS initialization
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(Arrays.asList(fromStationName));

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String currentStation = path.get(path.size() - 1);

            if (!visited.contains(currentStation)) {
                visited.add(currentStation);

                List<String> neighbors = stations.get(currentStation);
                if (neighbors != null) {
                    for (String neighbor : neighbors) {
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        if (neighbor.equals(toStationName)) {
                            return newPath;
                        } else {
                            queue.add(newPath);
                        }
                    }
                }
            }
        }
        return null;
    }

    // Test case to validate the solution
    public static boolean doTestsPass() {
        TrainStationShortestPath tm = new TrainStationShortestPath();

        // Creating the train map
        tm.addStation("King's Cross St Pancras", "Angel");
        tm.addStation("King's Cross St Pancras", "Russell Square");
        tm.addStation("King's Cross St Pancras", "Farringdon");
        tm.addStation("Angel", "Old Street");
        tm.addStation("Old Street", "Moorgate");
        tm.addStation("Moorgate", "Barbican");
        tm.addStation("Barbican", "Farringdon");
        tm.addStation("Russell Square", "Holborn");
        //tm.addStation("Farringdon", "Russell Square");
        tm.addStation("Holborn", "Chancery Lane");
        tm.addStation("Chancery Lane", "St Paul's");
        tm.addStation("St Paul's", "Bank");
        //tm.addStation("Farringdon", "Holborn");

        // Test case
        List<String> result = tm.shortestPath("King's Cross St Pancras", "Chancery Lane");
        List<String> expected = Arrays.asList("King's Cross St Pancras", "Farringdon", "Barbican", "Moorgate");

        return result.equals(expected);
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail");
        }
    }
}
