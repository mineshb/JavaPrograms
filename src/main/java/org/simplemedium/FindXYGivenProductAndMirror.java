package org.simplemedium;

import java.util.*;
/**
 * 28. Given the product of numbers, say x and Y. Find out the values are X and Y, provided X and Y should be mirror numbers.
 */
public class FindXYGivenProductAndMirror {

    public static void main(String[] args) {
        int input = 252;

        Set<Integer> factors = findAllDivisiveNumbers(input);
        System.out.println(factors);
 /*       int res = convertToMirror(124);
        System.out.println(res);
        res = convertToMirror(325);
        System.out.println(res);
*/
        Map<Integer, Integer> rMap = findMirrorNumber(factors);
        System.out.println(" Mirror Numbers "+ rMap);
    }

    private static Map<Integer, Integer> findMirrorNumber(Set<Integer> factors) {
        Map<Integer, Integer> rMap = new HashMap<>();
        for(int i : factors) {
            int mirror = convertToMirror(i);
            if(i!= mirror && factors.contains(mirror)) {
                rMap.put(i, mirror);
            }
        }
        return rMap;
    }

    private static int convertToMirror(int input) {
        int reversed = 0;
        while (input != 0) {
            int digit = input%10;
            reversed = (reversed*10)+ digit;
            input /= 10;
        }
        return reversed;

    }

    private static Set<Integer> findAllDivisiveNumbers(int input) {
        Set<Integer> divisors = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                divisors.add(i);

                // Check if the divisor pair is different and avoid adding square root twice
                if (i != input / i) {
                    divisors.add(input / i);
                }
            }
        }
        return divisors;
    }

}
