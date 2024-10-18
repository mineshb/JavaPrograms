package org.simplemedium;

import java.util.HashSet;
import java.util.Set;

/*
11. Given two arrays. Arr1 = {1,2,3,8}, arr2 = {5,6,4,7}.
Find a number from each array to be interchanged to reach a common sum of all elements for both arrays.
Output: {1,5} or {3,7} or {2,6}
 */


/* Solution:
To swap elements x from Arr1 and y from Arr2 such that the sums of the arrays become equal, the following condition must be satisfied:

Sum1 − 𝑥  +  𝑦 = Sum2 − 𝑦 + 𝑥
Sum1−x+y=Sum2−y+x

This simplifies to:

𝑥 − 𝑦  = (Sum1 − Sum2) / 2

 */
    public class FindCommonSumOfArray {

        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 8};
            int[] arr2 = {5, 6, 4, 7};

            int[] result = findSwapPair(arr1, arr2);

            if (result != null) {
                System.out.println("Swap elements: " + result[0] + " (from arr1) and " + result[1] + " (from arr2)");
            } else {
                System.out.println("No valid pair found.");
            }
        }

        public static int[] findSwapPair(int[] arr1, int[] arr2) {
            // Calculate the sums of both arrays
            int sum1 = calculateSum(arr1);
            int sum2 = calculateSum(arr2);

            // Calculate the difference
            int diff = (sum1 - sum2) / 2;

            // Use a set to store elements of arr2
            Set<Integer> setArr2 = new HashSet<>();
            for (int num : arr2) {
                setArr2.add(num);
            }

            // Find a valid pair
            for (int num1 : arr1) {
                if (setArr2.contains(num1 - diff)) {
                    return new int[]{num1, num1 - diff};
                }
            }

            return null;
        }

        // Helper method to calculate the sum of an array
        private static int calculateSum(int[] array) {
            int sum = 0;
            for (int num : array) {
                sum += num;
            }
            return sum;
        }
    }

