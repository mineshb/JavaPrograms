package org.simplemedium;

import java.util.HashMap;
import java.util.Map;

/*
Java Program to Find Duplicate Character from a String and Count of repetition
 */
public class DuplicateCharCountInString {

    public static void main(String[] args) {
        String inputString = "MMIINNESHHhhhh";
        Map<Character,Integer>  result = findDuplicateCharactersWithCount(inputString);
        result.entrySet().removeIf(entry -> entry.getValue() == 1);
        System.out.println("Following are the list of duplicate characters along with its count:" + result);
    }

    public static Map<Character,Integer> findDuplicateCharactersWithCount(String input) {
        Map<Character, Integer> result = new HashMap<>();
        for(char c: input.toUpperCase().toCharArray()) {
            result.merge(c,1,Integer::sum);
            /* merge function above does the same operation
            if(result.containsKey(c)) {
                result.put(c, (int) result.get(c)+1);
            }
            else {
                result.put(c, 1);
            }
            */
        }

        return result;
    }
}
