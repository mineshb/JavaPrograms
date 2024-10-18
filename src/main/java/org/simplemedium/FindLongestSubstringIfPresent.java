package org.simplemedium;

/*
24. given two string check whether the substring of one is present in another string
    {"padmaja","maj"} return true
    2. use the above method in this question
    Given 3 string, find the longestsubstring present in the string whose length is high
    {"padmaja", "maj", "maja"}
    -> here "maja" should be returned and not "padmaja" (as padmaja is a not a substring of any other string)
    only "maj" or "maja" is a substring of "padmaja", in that longest substring should be returned.
    There could be other inputs which are not part of any substring as well. exlude them like {"padmaja","wxyz","maj"}
 */
public class FindLongestSubstringIfPresent {

    public static void main(String[] args) {
        // Test cases
        System.out.println(isSubstringPresent("padmaja", "maj"));  // Output: true
        System.out.println(findLongestSubstring(new String[]{"padmaja", "maj", "maja"}));  // Output: maja
        System.out.println(findLongestSubstring(new String[]{"padmaja", "wxyz", "maj"}));  // Output: maj
    }

    // Method to check if one string is a substring of another
    public static boolean isSubstringPresent(String str1, String str2) {
        return str1.contains(str2);
    }

    // Method to find the longest substring present in the string with the highest length
    public static String findLongestSubstring(String[] strings) {
        // Edge case: If the array has fewer than 2 strings, there is no meaningful comparison
        if (strings.length < 2) {
            return null;
        }

        // Find the string with the maximum length
        String longestString = "";
        for (String str : strings) {
            if (str.length() > longestString.length()) {
                longestString = str;
            }
        }

        // Find the longest substring present in the longest string
        String longestSubstring = "";
        for (String str : strings) {
            if (!str.equals(longestString)) {
                if (isSubstringPresent(longestString, str) && str.length() > longestSubstring.length()) {
                    longestSubstring = str;
                }
            }
        }

        // If no valid substring is found, return null or an appropriate message
        return longestSubstring.isEmpty() ? null : longestSubstring;
    }
}