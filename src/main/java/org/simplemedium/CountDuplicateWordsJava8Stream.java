package org.simplemedium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CountDuplicateWordsJava8Stream {
    public static void main(String[] args) {
        int[] inputArr ={1, 2, 3, 2, 4, 1, 1, 2, 1, 3, 1};
        System.out.println(Arrays.toString(shiftOnesToLeft(inputArr)));
    }

    public static int[] shiftOnesToLeft(int[] arr) {
        int j = 0;  // Pointer to place the 1s

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (i != j) {  // Only swap if i and j are not the same
                    arr[i] = arr[j];
                    arr[j] = 1;
                }
                j++;
            }
        }
        return arr;
    }

}
