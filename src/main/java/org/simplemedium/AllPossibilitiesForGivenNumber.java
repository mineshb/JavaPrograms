package org.simplemedium;

import java.util.ArrayList;
import java.util.List;

/*
Write a program to print all possibilites to get the given number as mentioned below:
Given number is 3.
Output:
1+1+1
1+2
2+1
 */
public class AllPossibilitiesForGivenNumber {
    public static void main(String[] args) {
        int input = 5;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        findCombinations(input, new ArrayList<>(), result);
        System.out.println("Final Result = " + result);
    }

    public static void findCombinations(int target, List<Integer> current, List<List<Integer>> results) {
        if (target == 0) {
            // If the target is zero, we've found a valid combination
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = 1; i <= target; i++) {

            // Choose the current number
            current.add(i);

            // Recursively find the combinations with the remaining target
            findCombinations(target - i, current, results);

            // Remove the current number to backtrack and try the next possibility
            current.remove(current.size() - 1);
        }
    }

}
