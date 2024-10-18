package org.simplemedium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxValueInArray {

    public static void main(String[] args) {
        Integer[] arr = {5, 7, 93, 6, 11, 81, 2};
        List<Integer> list = Arrays.asList(arr);

        int maxValue = Collections.max(list);
        System.out.println("Max Value is =" + maxValue);

        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);

    }
}
