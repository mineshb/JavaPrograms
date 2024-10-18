package org.simplemedium;

import java.util.Arrays;

/**
28. dot product of two arrays
 long dotProduct( int[] array1, int[] array2 )
   *
   * Given two arrays of integers, returns the dot product of the arrays"
    int[] arr1 = {1, 2, 3, 4, 5};
    int[] arr2 = {6, 7, 8, 9, 10};
    do Product output:  115
 */
public class DotProductOfArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        int[] arr3;
        if(arr1.length == arr2.length){
            arr3 = new int[arr1.length];
            Arrays.fill(arr3,0);
            for(int i=0; i< arr1.length; i++) {
                arr3[i] += arr1[i]*arr2[i];
            }
            System.out.println("The dot product of given 2 arrays :" + Arrays.stream(arr3).sum());
        }

    }
}
