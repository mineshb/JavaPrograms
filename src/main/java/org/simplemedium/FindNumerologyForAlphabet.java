package org.simplemedium;

import java.util.HashMap;
import java.util.Map;

/*
17. Find out the numerology number for the given name as mentioned below:
Each alphabet represented with one number as given :
A,I,J,Q,Y - 1
B,K,R-2
C,G,L,S - 3
D,M,T - 4
E,H,N,X -5
U,V,W-6
O,Z-7
F-P-8
Ex. If input String is "S. KANAPATHY" then output should be 4.
S. KANAPATHY ==> 3+2+1+5+1+8+1+4+5+1=31 (3+1) = 4
 */
public class FindNumerologyForAlphabet {

    public static void main(String[] args) {
        Map<Character, Integer> numerologyMap = new HashMap<>();
        numerologyMap.put('A', 1); numerologyMap.put('I', 1); numerologyMap.put('J', 1); numerologyMap.put('Q', 1); numerologyMap.put('Y', 1);
        numerologyMap.put('B', 2); numerologyMap.put('K', 2); numerologyMap.put('R', 2);
        numerologyMap.put('C', 3); numerologyMap.put('G', 3); numerologyMap.put('L', 3); numerologyMap.put('S', 3);
        numerologyMap.put('D', 4); numerologyMap.put('M', 4); numerologyMap.put('T', 4);
        numerologyMap.put('E', 5); numerologyMap.put('H', 5); numerologyMap.put('N', 5); numerologyMap.put('X', 5);
        numerologyMap.put('U', 6); numerologyMap.put('V', 6); numerologyMap.put('W', 6);
        numerologyMap.put('O', 7); numerologyMap.put('Z', 7);
        numerologyMap.put('F', 8); numerologyMap.put('P', 8);

        String input = "S. KANAPATHY";

        int numerologySum = 0;
        for(char c : input.toUpperCase().toCharArray()) {
            if(numerologyMap.containsKey(c)) {
                numerologySum += numerologyMap.get(c);
            }
        }
        System.out.println("Numerology value = "+ numerologySum + " : " + getSingleDigit(numerologySum));
    }

    public static int getSingleDigit(int input) {
        int sum = 0;
        while (input > 0) {
            sum += input % 10;
            input /= 10;
        }
        return sum;
    }
}
