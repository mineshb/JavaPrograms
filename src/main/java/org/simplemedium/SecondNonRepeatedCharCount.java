package org.simplemedium;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Write the program to get second non-repeated char from string
 */
public class SecondNonRepeatedCharCount {
    public static void main(String[] args) {
        String[]  inputs = {"swiss", "character", "abracadabra"};
        for (String str: inputs) {

            char secondNonRepeatedChar = findSecondNonRepeatedChar(str);
            System.out.println("Second non-repeated character for " + str + " is : " + secondNonRepeatedChar);

        }
    }

    static char findSecondNonRepeatedChar(String str) {
        int[] charCount = new int[256]; // Assuming ASCII characters

        HashMap<Character, Integer> hmCharCount = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hmCharCount2 = new HashMap<Character, Integer>();

        // Count the occurrences of each character
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            hmCharCount.put(c, ++charCount[c]);
        }

        // Count the occurrences of each character
        for (char ch : str.toCharArray()) {
            hmCharCount2.put(ch, hmCharCount2.getOrDefault(ch, 0) + 1);
        }



        System.out.println(hmCharCount);
        System.out.println(hmCharCount2);
        // Find the second non-repeated character
        // Identify the second non-repeated character
        int nonRepeatedCount = 1;
        for (char ch : str.toCharArray()) {
            System.out.println(ch + " : " + hmCharCount2.get(ch));
            if (hmCharCount2.get(ch) == 1) {
                nonRepeatedCount++;
                if (nonRepeatedCount == 2) {
                    return ch;
                }
            }
        }


        for(Map.Entry<Character, Integer> hmIterator : hmCharCount.entrySet() ) {
            //hmIterator
        }

        // Find the second non-repeated character


        // If no second non-repeated character found, return a default value (e.g., ' ')
        return 'P';
    }
}
