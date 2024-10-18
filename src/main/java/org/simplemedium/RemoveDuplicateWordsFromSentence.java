package org.simplemedium;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWordsFromSentence {

    public static void main(String[] args) {
        String sentence = "This is a test sentence with test words and words repeated";
        String result = removeDuplicateWords(sentence);
        System.out.println("Original Sentence :" + sentence);
        System.out.println("Sentence after removing duplicates: " + result);

         sentence = "Good day day bye bye";
         result = removeDuplicateWords(sentence);
        System.out.println("Original Sentence :" + sentence);
        System.out.println("Sentence after removing duplicates: " + result);

        sentence = "greet the day user greet good day";
        result = removeDuplicateWords(sentence);
        System.out.println("Original Sentence :" + sentence);
        System.out.println("Sentence after removing duplicates: " + result);
    }

    public static String removeDuplicateWords(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split("\\s+");

        // Use LinkedHashSet to maintain insertion order while removing duplicates
        Set<String> uniqueWords = new LinkedHashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        // Join the unique words back into a sentence
        return String.join(" ", uniqueWords);
    }
}
