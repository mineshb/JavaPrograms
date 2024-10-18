package org.leetcode;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(120232021));
    }

    public static boolean isPalindrome(int x) {

        // Negative numbers are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10; // Move last digit of x to reversedHalf
            x /= 10; // Remove the last digit of x
        }

        // If x is equal to reversedHalf, or if x is equal to reversedHalf/10 for odd-length numbers
        return x == reversedHalf || x == reversedHalf / 10;
    }

}
