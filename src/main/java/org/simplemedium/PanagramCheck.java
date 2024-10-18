package org.simplemedium;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class PanagramCheck {

    public static void main(String[] args) {
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog",
               /* "Pack my box with five dozen liquor jugs",
                "Jinxed wizards pluck ivy from the big quilt",*/
                "this is probably not a panagram xyz qer kuwv"
        };

        List<Character> missingChars = new ArrayList<>();

        for(String str: sentences) {
            //missingChars = isPanagram(str);
            Set<Character> missingCharsSet = findMissingChars(str);
            //if(missingChars.isEmpty()) {
            if(missingCharsSet.isEmpty()) {
                System.out.println("The following string is a panagram: \r\n " + str);
            }
            else {
                System.out.println("The following string is a not a panagram: \r\n " + str);
                System.out.println("The missing characters are : " + missingCharsSet.toString());
            }
        }
    }

    public static List<Character> isPanagram(String str) {
        String strLower = str.toLowerCase().replaceAll("[^a-z]", "");
        List<Character> missingChars = new ArrayList<>();
        for(char c='a'; c<='z'; c++) {
            if(!strLower.contains(Character.toString(c))) {
                missingChars.add(c);
            }
        }
        return missingChars;
    }


    public static Set<Character> findMissingChars(String str) {
        String strLower = str.toLowerCase().replaceAll("[^a-z]", "");
        Set<Character> alphabetSet = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetSet.add(c);
        }


        Set<Character> presentChars = new HashSet<>();
        for (char c : strLower.toCharArray()) {
            presentChars.add(c);
        }


        Set<Character> missingChars = new HashSet<>(alphabetSet);
        missingChars.removeAll(presentChars);

        return missingChars;
    }

}
