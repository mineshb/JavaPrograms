package org.simplemedium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * "Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * // Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * // Output: [2,2,2,1,4,3,3,9,6,7,19]"
 */
public class SortArrayWithReferenceToAnotherArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(getSortedArray(arr1, arr2)));
    }

    private static int[] getSortedArray(int[] arr1, int[] arr2) {
        // Step 1 - Create Frequency Map of Array 1 Items having presence in array 2
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int n : arr1) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0)+1);
        }
        System.out.println(frequencyMap);

        // Step 2 - Sort the array based on elements in Array 2
        int[] result = new int[arr1.length];
        int ind = 0;
        for(int n2 : arr2) {
            int count = frequencyMap.getOrDefault(n2, 0);
            while(count-- > 0) {
                result[ind++] = n2;
            }
            frequencyMap.remove(n2);
        }

        // Step 3 - Add remaining elements
        for(int n3 : frequencyMap.keySet()) {
            result[ind++] = n3;
        }

        return result;
    }

}
