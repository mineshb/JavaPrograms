package org.simplemedium;

/**
4. Find the weight of given String.
(A-Z/a-z) we have 26 alphabetic, consider the position of a-z alphabets as 1-26. Based on that find the weight of the given String.
Ex:
Given String: Apple
Output: 1+16+16+12+5 = 50
 */
public class StringWeightCalculator {

    public static void main(String[] args) {
        String input = "Apple";
        int weight = calculateWeight(input);
        System.out.println("Weight of the given string: " + weight);
    }

    public static int calculateWeight(String str) {
        int totalWeight = 0;

        // Convert string to lowercase to handle both uppercase and lowercase letters uniformly
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                // Calculate weight: 'a' = 1, 'b' = 2, ..., 'z' = 26
                int weight = ch - 'a' + 1;
                totalWeight += weight;
            }
        }

        return totalWeight;
    }
}
