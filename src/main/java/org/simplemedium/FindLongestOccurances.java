package org.simplemedium;

/**
5. Question: For the given string such as "aabbbbbcc" print the longest occurring character,index and number of times it occurs.
Ex: longest occurring character is b and length is 5 at index 2.
 */
public class FindLongestOccurances {
    public static void main(String[] args) {
        String input = "aabbbbbcc";
        Result result = findLongestOccurancesOfCharacter(input);
        System.out.println(result);
    }

    public static Result findLongestOccurancesOfCharacter(String input) {

        Result res = new Result();
        int startIndex = 0;
        int currentIndex = 0;
        int lenCharSequence = 0;
        char previousChar = ' ';

        for (char c : input.toCharArray()) {
            if(previousChar == c) {
                lenCharSequence++;
            }
            else {
                lenCharSequence = 1;
                startIndex = currentIndex;
            }

            if(lenCharSequence > res.getLengthOfChar()) {
                res.setLengthOfChar(lenCharSequence);
                res.setLongestChar(c);
                res.setStartIndex(startIndex);
            }

            // End of iteration
            previousChar = c;
            currentIndex++;
        }

        return res;
    }

    static class Result {
        int startIndex;
        int lengthOfChar;
        char longestChar;

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public void setLengthOfChar(int lengthOfChar) {
            this.lengthOfChar = lengthOfChar;
        }

        public void setLongestChar(char longestChar) {
            this.longestChar = longestChar;
        }

        @Override
        public String toString() {
            return "Result[startIndex="+startIndex+", lengthOfChar="+lengthOfChar+", longestChar="+longestChar+"]";
        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getLengthOfChar() {
            return lengthOfChar;
        }

        public char getLongestChar() {
            return longestChar;
        }
    }
}
