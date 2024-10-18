package org.simplemedium;

import java.util.*;

/**
10. For the given Array, accept the target value as input and find out the sum of minimum elements required to find the target value.
Example :
Array : { 1,2,3,4}
Target Value = 6
out put = 2+4 =6 return 2 element required .

Target Value = 12
output = 1+2+3+4 = 10 return -1 target value out of Scope .
 */
public class SumOfMinimumElementForTarget {

    public static void main(String[] args) {
        Integer[] input = {1,2,3,4};
        List<Integer> list =  Arrays.asList(input);
        //findMinElementsForSum(new ArrayList(), list,12);

        // Find and print the result
        List<Integer> result = findMinimumElementsForTargetSum(new Integer[]{1,2,3,4}, 5);
        if (result.isEmpty()) {
            System.out.println("Target value out of scope.");
        } else {
            System.out.println("Elements: " + result);
        }
    }
    public static void findMinElementsForSum(List<Integer> result, List<Integer> list, int target) {

        int total = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(total);
        if(total < target) {
            return;
        }
    }

    public static List<Integer> findMinimumElementsForTargetSum(Integer[] array, int targetValue) {
        // Sort the array in descending order
        Arrays.sort(array, Collections.reverseOrder());
        Arrays.stream(array).forEach(System.out::print);
        /*for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println();
        Arrays.stream(array).forEach(System.out::print);*/

        int sum = 0;
        List<Integer> elements = new ArrayList<>();

        // Iterate through the array and sum up the elements
        for (int num : array) {
            if (sum + num <= targetValue) {
                sum += num;
                elements.add(num);
                if (sum == targetValue) {
                    return elements;
                }
            }
        }

        // If target value cannot be reached, return an empty list
        return new ArrayList<>();
    }



}
