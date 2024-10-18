package org.simplemedium;

/**
3. Print all Armstrong number between 1 to 1000.
An Armstrong number is a n-digit number that is equal to the sum of nth power of its digits. For example,
6 = 61 = 6
371 = 33 + 73 + 13 = 371

"Implement the method that provided numerator and denominator will return a string representing fraction's decimal form.
   * Some fractions in decimal form have cyclic decimal points.
   *
   * Examples:
   * 1/2 = 0.5
   * 1/3 = 0.(3)"
 */
public class ArmStrongNumberCheck {

    public static void main(String[] args) {

        boolean bArmStrNum;
        for(int i =0; i< 1000; i++) {
            if(isArmStrongNumber(i))
                System.out.println(i + " IS  a armstrong number");
        }
    }

    public static boolean isArmStrongNumber(int num) {

        String sNumber = Integer.toString(num);
        int len = sNumber.length();
        int sumOfPower = 0;
        for(char c : sNumber.toCharArray()) {
            int n = c - '0';
            sumOfPower += Math.pow(n,len);
        }

        return (num == sumOfPower);
    }

    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int numberOfDigits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            number /= 10;
        }

        return sum == originalNumber;
    }




}
