package org.simplemedium;

import java.util.HashSet;
import java.util.Set;

/**
 * 9. Find out unique substring of given length of string.
 * EX:
 * Input - (aab,2) , Output - aa, ab
 * Input- (aabc,2), Output - aa, ab,bc
 * Input -(abc,1), Output - a,b,c
 */
public class FindUniqueSubstring {

    public static void main(String[] args) {
        System.out.println(findUniqueSubstrings("aab", 2)); // Output: [aa, ab]
        System.out.println(findUniqueSubstrings("aabc", 2)); // Output: [aa, ab, bc]
        System.out.println(findUniqueSubstrings("abc", 1)); // Output: [a, b, c]
    }

    public static Set<String> findUniqueSubstrings(String input, int length) {
        Set<String> substrings = new HashSet<>();

        if (length > input.length() || length <= 0) {
            throw new IllegalArgumentException("Length must be between 1 and the length of the string.");
        }

        for (int i = 0; i <= input.length() - length; i++) {
            String substring = input.substring(i, i + length);
            substrings.add(substring);
        }

        return substrings;
    }

}
