package org.simplemedium;

import java.util.HashMap;
import java.util.Map;

/**
 * How to Count occurrences of each character in a String in java
 *
 * 20. Write a program which would take a string as input like 'aabccd' and print the occurances of characters  in the format a=2,b=1,c=2,d=1
 */
public class OccuranceOfCharacter {

    public static Map<Character,Integer> getCountOfCharacterOccurrences(String str) {
        Map<Character, Integer> hMap = new HashMap<Character,Integer>();
        char[] chars = str.toCharArray();
        for(char c : chars) {
            hMap.merge(c, 1, Integer::sum);
           /* if(!hMap.containsKey(c)) {
                hMap.put(c, 1);
                //System.out.println("count of " + c + " is " + hMap.get(c));
            }
            else {
                hMap.put(c, hMap.get(c) + 1);
                //System.out.println("count of == " + c + "== is " + hMap.get(c));
            }*/
        }

        return hMap;
    }

    public static void main(String[] args) {
        String[] words = {"character"}; //, "cartoon", "abracadabra", "circus", "intermission"};
        for (String str: words) {
            System.out.println("Input = " + str);
            Map<Character, Integer> charWiseCount = getCountOfCharacterOccurrences(str);

            for(Map.Entry<Character, Integer>  entry : charWiseCount.entrySet()) {
                System.out.println("Character : " + entry.getKey() + " Count = "+ entry.getValue());
            }
        }

    }


}
