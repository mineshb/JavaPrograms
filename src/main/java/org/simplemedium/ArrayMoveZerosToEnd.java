package org.simplemedium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
26.  Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:
    Input: nums = [0]
    Output: [0]
 */
public class ArrayMoveZerosToEnd {

    public static void main(String[] args) {

        //int[] inputArr = getInputArr();
        int temp;
        int[] inputArr = {0,1,0,3,12, 0};//, 0, 11, 5, 0, 1};

        moveZerosToEnd(inputArr);
        System.out.println(Arrays.toString(inputArr));
        /*
        int inputLen = inputArr.length;
        for(int i = 0; i < inputLen; i++) {
            int j = i;
            System.out.print(" j = " + j);
            if(inputArr[i] == 0){
                while(inputArr[j] == 0) {
                    j = j+1;
                    if(j > inputLen-1) {
                        System.out.println(Arrays.toString(inputArr));
                        return;
                    }
                }
                if(j < inputLen - 1) {
                    temp = inputArr[i];
                    inputArr[i] = inputArr[j];
                    inputArr[j] = temp;
                }
            }
            if(i == inputLen-1 && inputArr[j] == 0) {
                temp = inputArr[j];
                inputArr[j] = inputArr[i];
                inputArr[i] = temp;
            }
        }
         */
    }

    public static void moveZerosToEnd(int[] nums) {
        int nonZeroIndex = 0; // Position to place the next non-zero element

        // Move non-zero elements to the beginning of the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap the elements
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;
                nonZeroIndex++;
            }
            System.out.println(Arrays.toString(nums));
        }
    }


    private static int[] getInputArr() {
        Scanner inputScan =  new Scanner(System.in);
        System.out.print("Please enter size of array e.g., number of elements you  want to put in the array :");
        int n = inputScan.nextInt();

        int[] inputArr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Please enter element # " + i + ": ");
            inputArr[i] = inputScan.nextInt();
        }
        inputScan.close();
        System.out.println(Arrays.toString(inputArr));
        return inputArr;
    }
}
