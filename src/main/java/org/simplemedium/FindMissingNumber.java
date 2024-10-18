package org.simplemedium;

import java.util.Arrays;

/**
 * 16. Write a Java Program to Find missing Number in an Array
 *
 *         Formula to remember:
 *         S = N*(N+1)/2
 *         Missing Number = Sum of Numbers  - S
 */

public class FindMissingNumber {

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,4,5,6},
                {0,2,3},
                {1,2,3,4,5,7,8,9,10}
        };

        for(int[] a: arr) {
            System.out.println("The missing value in the array is = " + findMissingNumber(a, a[a.length - 1]));
        }
    }

    public static int findMissingNumber(int[]  arr, int n) {
        int s = (n * (n+1))/2;
        int sum = Arrays.stream(arr).sum();

        return s - sum;
    }
}
