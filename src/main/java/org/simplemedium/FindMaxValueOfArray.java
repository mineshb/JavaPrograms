package org.simplemedium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMaxValueOfArray {
    public static void main(String[] args) {
        Integer[] arr = { 10, 3, 524, 211, 120, 32};
        System.out.println(("the max value of array is " + findMaxValue(arr)));
    }

    public static Integer findMaxValue(Integer[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }


        List<Integer> arrList = Arrays.asList(arr);
        return Collections.max(arrList);
    }
}
