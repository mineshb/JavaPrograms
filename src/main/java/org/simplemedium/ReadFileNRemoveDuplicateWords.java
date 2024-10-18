package org.simplemedium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFileNRemoveDuplicateWords {

    public static void main(String[] args) {

        String filePath = "c:\\Test\\test.txt";
        Map<String, Integer> result = findDuplicateWords(filePath);
        result.entrySet().removeIf(entry -> entry.getValue()==1);
        System.out.println("Following are the duplicate words and its count : " + result);
    }

    public static Map<String, Integer> findDuplicateWords(String filePath) {
        Map<String, Integer> result = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split(("\\W")); // Split the line into words
                for(String w:words) {
                    if(!w.isEmpty()) {
                        result.merge(w, 1, Integer::sum);
                    }
                }
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}


