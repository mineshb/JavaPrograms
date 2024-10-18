package org.simplemedium;

import java.util.Arrays;

/**
23. Given two sorted arrays, the task is to merge them in a sorted manner .
Example:1
Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}
Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}
Example 2:
Input: arr1[] = { 3,7,9,12,21}, arr2[] = {6,8,15,18,27}
Output: arr3[] = {3,6,7,8,9,12,15,18,21,27}
Example 3:
Input: arr1[] = { 3,7,9,-12,21,12}, arr2[] = {6,8,15,-18,27}
Output: arr3[] = {-18,-12,3,6,7,8,9,12,1521,27}
Time complexity: O(n1+n2) where n1 and n2 are size of each array.
 */
public class MergeAndSortArrays {
    public static void main(String[] args) {
        int[] result;
        int[] arr1 = { 3,7,9,12,21};
        int[]  arr2 = {6,8,15,18,27};
        result = mergeAndSortTwoArrays(arr1, arr2);
        Arrays.stream(result).forEach(System.out::print);
    }

    public static int[] mergeAndSortTwoArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length+arr2.length];

       int i=0, j=0, k=0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            }
            else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of array 1
        while(i < arr1.length) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements of array 2
        while(j < arr2.length) {
            result[k++] = arr2[j++];
        }


        return result;
    }
}


