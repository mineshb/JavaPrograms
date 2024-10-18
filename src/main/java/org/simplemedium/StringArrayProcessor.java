package org.simplemedium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
5. Write a program to print .
    A. all String which starts as "S" from the given String array
    B. Find out if String has all Unique Characters
    Ex:
    Input: {"apple","sample", "search","cat"}
    output: { "sample", "search"}
 */
public class StringArrayProcessor {

    public static void main(String[] args) {
        String[] inputArray = {"apple", "sample", "search", "cat"};

        // Part A: Print all strings that start with "S"
        System.out.println("Strings that start with 'S':");
        for (String str : inputArray) {
            if (str.toLowerCase().startsWith("s")) {
                System.out.println(str);
            }
        }

        // Part B: Check if each string has all unique characters
        System.out.println("\nStrings with all unique characters:");
        for (String str : inputArray) {
            if (hasUniqueCharacters(str)) {
                System.out.println(str);
            }
        }
    }

    // Helper method to check if a string has all unique characters
    public static boolean hasUniqueCharacters(String str) {
        Set<Character> charSet = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (!charSet.add(ch)) {
                return false; // Duplicate character found
            }
        }
        return true; // All characters are unique
    }
}