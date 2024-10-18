package org.simplemedium;

import java.util.Arrays;
import java.util.Comparator;

/*
25. Input: {"1","A","B","C","2","3","F","V","5"} order all the numbers then Uppercase letters, expected output: {"1","2","3","4","5","A","B","C","F","V"}
 */
public class SortArrayWithNumberAndCharacters {

    public static void main(String[] args) {
        // Input array
        String[] input = {"1", "A", "B", "C", "2", "3", "F", "V", "5"};
        // Expected output
        String[] output = sortNumbersAndLetters(input);
        System.out.println(Arrays.toString(output));
    }

    public static String[] sortNumbersAndLetters(String[] input) {
        // Separate numbers and letters
        String[] numbers = Arrays.stream(input)
                .filter(s -> s.matches("\\d"))
                .toArray(String[]::new);

        String[] letters = Arrays.stream(input)
                .filter(s -> s.matches("[A-Z]"))
                .toArray(String[]::new);

        // Sort numbers and letters
        Arrays.sort(numbers, Comparator.comparingInt(Integer::parseInt));
        Arrays.sort(letters);

        // Combine results
        String[] sortedArray = new String[numbers.length + letters.length];
        System.arraycopy(numbers, 0, sortedArray, 0, numbers.length);
        System.arraycopy(letters, 0, sortedArray, numbers.length, letters.length);

        return sortedArray;
    }
}
