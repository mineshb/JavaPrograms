package org.simplemedium;

/**
 * 2. Check the given number is Strong number or not.
 * Strong number is a special number whose sum of factorial of digits is equal to the original number.
 * For example: 145 is strong number. Since, 1! + 4! + 5! = 145
 */
public class StrongNumberCheck {

    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 30, 40, 145, 1320, 23};
        for(int i : arr) {
           System.out.println(i + " " + (isStrongNumber(i) ? " **is** " : " is NOT "  ).toString() + " a strong number");
        }
    }

    public static boolean isStrongNumber(int num) {

        String sNumber = Integer.toString(num);
        int sumOfFactorial = 0;
        for(char c : sNumber.toCharArray()) {
            int n = c - '0';
            //System.out.println(n);
            sumOfFactorial += getFactorial(n);
        }

        /*System.out.println("sNumber =" + num);
        System.out.println("sumOfFactorial =" + sumOfFactorial);*/

        return (num == sumOfFactorial);
    }

    public static int getFactorial(int num) {
        if(num <= 1) return 1;
        int result = num * getFactorial(num - 1);
        return result;
    }

}
