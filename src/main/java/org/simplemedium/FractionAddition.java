package org.simplemedium;

import java.util.Scanner;

/**
    26. Add two fraction a/b and c/d and print answer in simplest form.

    Examples :

    Input:  1/2 + 3/2
    Output: 2/1

    Input:  1/3 + 3/9
    Output: 2/3

    Input:  1/5 + 3/15
    Output: 2/5
 */
public class FractionAddition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first fraction (a/b): ");
        String[] firstFraction = scanner.nextLine().split("/");
        int a = Integer.parseInt(firstFraction[0]);
        int b = Integer.parseInt(firstFraction[1]);

        System.out.print("Enter second fraction (c/d): ");
        String[] secondFraction = scanner.nextLine().split("/");
        int c = Integer.parseInt(secondFraction[0]);
        int d = Integer.parseInt(secondFraction[1]);

        // Calculate the result of addition
        int[] result = addFractions(a, b, c, d);

        // Print the result
        System.out.println("Result: " + result[0] + "/" + result[1]);
    }

    private static int[] addFractions(int a, int b, int c, int d) {
        // Find the Least Common Denominator (LCD)
        int lcm = lcm(b, d);

        // Adjust numerators to the common denominator
        int numerator1 = a * (lcm / b);
        int numerator2 = c * (lcm / d);

        // Add numerators
        int numerator = numerator1 + numerator2;
        int denominator = lcm;

        // Simplify the result
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        return new int[]{numerator, denominator};
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

}


