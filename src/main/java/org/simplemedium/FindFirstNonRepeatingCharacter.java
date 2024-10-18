package org.simplemedium;

import java.util.LinkedHashMap;
import java.util.Map;
/*
9. Write a program to find first non-repeating character from a input string
Ex:
Input : { "array", "apple", "rat"}
Output: y,a,r
 */
public class FindFirstNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatingChar("array"));
        System.out.println(findFirstNonRepeatingChar("apple"));
        System.out.println(findFirstNonRepeatingChar("rat"));
    }

    public static char findFirstNonRepeatingChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c : s.toCharArray()){
            map.merge(c, 1, Integer::sum);
        }
        map.entrySet().removeIf(entry->entry.getValue()>1);
        //System.out.println(map);
        return map.entrySet().iterator().next().getKey();
    }
}
