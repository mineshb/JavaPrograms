package org.leetcode;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] inputArr = {"flower","flow","flight"};
        longestCommonPrefix(inputArr);
    }

    public static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        char[] charsFirst = strs[0].toCharArray();
        char[] charsLast = strs[strs.length-1].toCharArray();
        int minLen = Math.min(charsFirst.length, charsLast.length);
        int i =0;
        for(i =0; i< minLen; i++) {
            if(charsFirst[i] != charsLast[i]) {
                break;
            }
        }

        ;

        System.out.println(charsFirst.toString());

        return charsFirst.toString().substring(0,i);

    }
}
