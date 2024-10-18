package org.complex;



/*

11. Given an array arr[] of distinct integers from 1 to N. The task is to find the minimum number of swaps required to sort the array.
Example:

Input: arr[] = { 7, 1, 3, 2, 4, 5, 6 }
Output: 5
Explanation:
i           arr             swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0, 3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0, 1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3, 4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4, 5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5, 6)
5   [1, 2, 3, 4, 5, 6, 7]
Therefore, total number of swaps = 5

Input: arr[] = { 2, 3, 4, 1, 5 }
Output: 3"

 */
import java.util.*;

public class MinimumSwapsToSortArray {

    public static void main(String[] args) {
        int[] arr1 = {7, 1, 3, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 4, 1, 5};
        int[] arr3 = {4, 3, 2, 1};
        int[] arr4 = {5, 4, 2, 3, 1};

        /*System.out.println("Minimum swaps required: " + minSwaps(arr1)); // Output: 5
        System.out.println("Minimum swaps required: " + minSwaps(arr2)); // Output: 3
        System.out.println("Minimum swaps required: " + minSwaps(arr3)); // Output: 2*/
        System.out.println("Minimum swaps required: " + minSwaps(arr4)); // Output: 2
    }

    public static int minSwaps(int[] arr) {
        int n = arr.length;

        // Create an array of pairs where first element is array element
        // and second element is the position of that element
        List<Pair> arrPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrPos.add(new Pair(arr[i], i));
        }

        // Sort the array by array element values to get the right position of elements
        arrPos.sort(Comparator.comparingInt(o -> o.value));

        // To keep track of visited elements
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        // Initialize result
        int swaps = 0;

        // Traverse array elements
        for (int i = 0; i < n; i++) {
            // already visited or already in the correct place
            if (visited[i] || arrPos.get(i).index == i) {
                continue;
            }

            // Find out the number of nodes in this cycle and add it to the result
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arrPos.get(j).index;
                cycleSize++;
            }

            // Update the number of swaps required
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    // Pair class to store value and index
    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
