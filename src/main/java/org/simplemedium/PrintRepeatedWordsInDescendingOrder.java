package org.simplemedium;

import java.util.*;
import java.util.stream.Collectors;

/*
25. Print the repeated top 5,10 words in decending order from the the below paragraph.
input : ""Sunset is the time of day when our sky meets the outer space solar winds. There are blue, pink, and purple swirls, spinning and twisting, like clouds of balloons caught in a whirlwind. The sun moves slowly to hide behind the line of horizon, while the moon races to take its place in prominence atop the night sky. People slow to a crawl, entranced, fully forgetting the deeds that must still be done. There is a coolness, a calmness, when the sun does set.""
example:
the=7, a=4, of=3, to=3, when=2, There=2, in=2, is=2, sun=2, and=2"
 */
public class PrintRepeatedWordsInDescendingOrder {

    public static void main(String[] args) {
        Map<String,Integer> wordsWithCount = new HashMap<>();
        String paragraph = "Sunset is the time of day when our sky meets the outer space solar winds. There are blue, pink, and purple swirls, spinning and twisting, like clouds of balloons caught in a whirlwind. The sun moves slowly to hide behind the line of horizon, while the moon races to take its place in prominence atop the night sky. People slow to a crawl, entranced, fully forgetting the deeds that must still be done. There is a coolness, a calmness, when the sun does set.";
        String[] words = paragraph.split("\\s");
        for(String word : words){
            wordsWithCount.merge(word, 1, Integer::sum);
        }
        Map<String, Integer> sortedMap = sortByValue(wordsWithCount, 5);
        sortedMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValue(Map<K, V> map, int numberOfTopElements) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(numberOfTopElements)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

}
