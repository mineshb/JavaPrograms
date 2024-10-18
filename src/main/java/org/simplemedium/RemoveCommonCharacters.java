package org.simplemedium;
import java.util.HashSet;
import java.util.Set;

public class RemoveCommonCharacters {

    public static void main(String[] args) {

        String str1 = "Hellow";
        String str2 = "Worlde";

        String result = removeCommonCharacters(str1, str2);
        System.out.println("Result = " + result);

        String result2 = removeCommonCharacters(str2, str1);
        System.out.println("Result = " + result2);
    }

    public static String removeCommonCharacters(String str1, String str2) {

        Set<Character> commonChars = new HashSet<>();

        for(char c : str2.toCharArray()  ) {
            commonChars.add(c);
        }

        StringBuilder sb1 = new StringBuilder();
        for(char c1 : str1.toCharArray()) {
            if(!commonChars.contains(c1)) {
                sb1.append(c1);
            }
        }

        return sb1.toString();
    }
}
