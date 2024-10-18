package org.simplemedium;

/*
15.Write a program to print all permutations of a given string.
 */
public class AllPermutationsOfString {
    public static void main(String[] args) {
        String str = "ABC";
        permute(str, 0, str.length() - 1);
    }




    /**
     * Method to print all permutations of a string
     * @param str the input string
     * @param left the starting index
     * @param right the ending index
     */
    public static void permute(String str, int left, int right) {
        if (left == right) {
            System.out.println(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                permute(str, left + 1, right);
                str = swap(str, left, i); // backtrack
            }
        }
    }

    /**
     * Method to swap characters at position i and j in a string
     * @param str the input string
     * @param i position of the first character
     * @param j position of the second character
     * @return the new string with swapped characters
     */
    public static String swap(String str, int i, int j) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

