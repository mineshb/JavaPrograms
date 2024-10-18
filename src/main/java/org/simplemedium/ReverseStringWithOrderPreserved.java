package org.simplemedium;

/**
 * 6. Find Reverse String With Preserving Order.
 * Ex:
 *   Input = abcd, output = dcba
 *   Input = I am Java Developer, Output  = r ep olev eDavajamI
 */
public class ReverseStringWithOrderPreserved {

    public static void main(String[] args) {
        String input1 = "abcd";
        String input2 = "I am Java Developer";


        System.out.println("Input: " + input2);
        System.out.println("Output: " + reverseStringPreservingOrder(input2));
    }

    public static String reverseStringPreservingOrder(String str) {
        // Step 1: Reverse the entire string
        String reversedString = new StringBuilder(str).reverse().toString();
        reversedString = reversedString.replace(" ", "");


        StringBuilder strFinal = new StringBuilder("");
        for(int i=0; i < reversedString.length(); i++) {
            if(str.charAt(i) == ' ') {
                strFinal.append(" ");
            }
            else {
                strFinal.append(reversedString.charAt(i));
            }
        }
        return strFinal.toString();
    }
}
