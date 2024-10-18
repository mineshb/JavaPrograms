package org.simplemedium;


public class  CheckNumerIsPowerOfAnotherNumber{

    /*
    10. How to find is power of 10
    Ex:
    Input : 100
    ouput: True (because 10 power 2 is 100)
    Input: 80
    Ouput: false (not power of 10)
     */
    public static void main(String[] args) {
        // Test cases
        System.out.println(isPowerOf(100, 10));  // Output: true
        System.out.println(isPowerOf(80, 8));   // Output: false
    }

    public static boolean isPowerOf(int number, int powerOf) {
        // Edge case for numbers less than or equal to zero
        if (number <= 0) {
            return false;
        }

        // Keep dividing by powerOf as long as divisible
        while (number % powerOf == 0) {
            number /= powerOf;
        }

        // If number is reduced to 1, it is a power of powerOf
        return number == 1;
    }
}

