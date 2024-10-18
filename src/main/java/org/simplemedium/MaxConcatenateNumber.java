package org.simplemedium;

import java.util.Arrays;
import java.util.Comparator;

/**
List of Integer let say {9,7,4,30} , concatenate each element and find out the maximum number
 */
public class MaxConcatenateNumber {

    public static void main(String[] args) {
        Integer[] numbers = {3, 10, 78, 9,0};
        String maxNumber = findMaxConcatenatedNumber(numbers);

        System.out.println("Maximum number formed: " + maxNumber);
    }

    public static String findMaxConcatenatedNumber(Integer[] numbers) {
        // Convert each integer to a string and sort based on the custom comparator
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // Concatenate in both possible orders and compare
                String order1 = a.toString() + b.toString();
                String order2 = b.toString() + a.toString();
                return order2.compareTo(order1); // Sort in descending order
            }
        });

        // Edge case: If the highest number is 0, the result should be "0"
        if (numbers[0] == 0) {
            return "0";
        }

        // Concatenate sorted numbers to form the maximum number
        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            result.append(number);
        }

        return result.toString();
    }
}

