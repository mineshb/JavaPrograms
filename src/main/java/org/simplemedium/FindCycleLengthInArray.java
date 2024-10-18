package org.simplemedium;

/**
29. Given an integer array of size n.
    Elements of the array is >= 0. Starting from arr[startInd], follow each element to the index it points to.
    Find a cycle and return its length.
    No cycle is found -> -1.

    lengthOfCycle([1, 0], 0); // 2
    lengthOfCycle([1, 2, 0], 0); // 3
    lengthOfCycle([1, 2, 3, 1], 0); // 3
 */
import java.util.*;

public class FindCycleLengthInArray {
    public static void main(String[] args) {
        int[] inputArr = {1,2,1};//{2, 0, 3, 4, 5, 6, 7, 8, 9, 4};
        try {
            int cycleLength = findCycleLength(inputArr, 0);
            if (cycleLength == -1) {
                System.out.println("No cycle found.");
            } else {
                System.out.println("Cycle length = " + cycleLength);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int findCycleLength(int[] inputArr, int startIndex) {
        int len = inputArr.length;

        // Validate the input array and startIndex
        if (len <= 0) {
            throw new IllegalArgumentException("Input array cannot be empty.");
        }
        if (startIndex < 0 || startIndex >= len) {
            throw new IllegalArgumentException("Start index is out of bounds.");
        }

        // Validate array values
        for (int i = 0; i < len; i++) {
            if (inputArr[i] < 0 || inputArr[i] >= len) {
                throw new IllegalArgumentException("Array contains invalid index.");
            }
        }

        // Detect cycle
        Map<Integer, Integer> visited = new HashMap<>();
        int currentIndex = startIndex;
        int steps = 0;

        while (!visited.containsKey(currentIndex)) {
            visited.put(currentIndex, steps);
            currentIndex = inputArr[currentIndex];
            steps++;

            if (currentIndex == startIndex) {
                return steps; // Cycle detected
            }
        }

        // Calculate the cycle length
        int cycleStartStep = visited.get(currentIndex);
        return steps - cycleStartStep;
    }
}


