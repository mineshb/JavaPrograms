package org.simplemedium;

import java.util.*;

/*
13. Given a list of words, group them by anagrams
 i/p: List of ""cat"",""dog"", ""god""
 o/p: A set of sets of Anagrams: {{""cat""},{""dog"",""god""}}
 */
public class AnagramGroups {

    public static List<Set<String>> groupAnagrams(String[] strs) {
        Map<String, Set<String>> anagramsMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!anagramsMap.containsKey(sortedStr)) {
                anagramsMap.put(sortedStr, new HashSet<>());
            }
            anagramsMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }

    public static List<Set<String>> groupAnagrams2(String[] words) {
        Map<String, Set<String>> hAnagrams = new HashMap<String, Set<String>>();

        for(String str : words) {
            char[] chars;
            chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            //System.out.println(chars);
            if(!hAnagrams.containsKey(sortedStr)) {
                hAnagrams.put(sortedStr, new HashSet<>());
            }
            hAnagrams.get(sortedStr).add(str);
        }

        return new ArrayList<>(hAnagrams.values());
    }

    public static void main(String[] args) {
        String[] words = {"cat", "dog", "god", "car","rac","opr","rpo","rop","kamal","makal","lakam"};

        List<Set<String>> groupedAnagrams = groupAnagrams2(words);

        System.out.println("Grouped Anagrams: " + groupedAnagrams);
    }
}
