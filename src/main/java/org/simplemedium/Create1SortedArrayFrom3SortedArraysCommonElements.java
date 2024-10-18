package org.simplemedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
22.
Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays in O(n).
Make sure the time complexity is met.

Example 1:
Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays
 */
public class Create1SortedArrayFrom3SortedArraysCommonElements {

    public static void main(String[] args) {
        int[] a1 = {1,2,3,4,5};
        int[] a2 = {1,2,5,7,9};
        int[] a3 = {1,3,4,5,8};

        int[] result = getSortedArray(a1, a2, a3);
        System.out.print("Common elements: ");
        System.out.println(Arrays.toString(result));
    }

    public static int[] getSortedArray(int[] a1, int[] a2, int[] a3) {
        List<Integer> result = new ArrayList<>();

        int j =0, k=0, m=0;
        while(j < a1.length && k < a2.length && m < a3.length) {
            if(a1[j] == a2[k] && a2[k] == a3[m]) {
                result.add(a1[j]);
                j++;
                k++;
                m++;
            }
            else if (a1[j] < a2[k] ){
                j++;
            }
            else if (a2[k] < a3 [m]) {
                k++;
            }
            else {
                m++;
            }
        }


        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
