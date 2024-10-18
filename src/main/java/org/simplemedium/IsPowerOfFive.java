package org.simplemedium;

public class IsPowerOfFive {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] testNumbers = {1, 5, 25, 30, 125, 0, -5, 29};

        for (int number : testNumbers) {
            if (checkIsPowerOf5(number, 5))
                System.out.println(number + " is power of 5");
            else
                System.out.println(number + " is NOT power of 5");
        }
    }

    private static boolean checkIsPowerOf5(int n, int p) {
        try {
            if (n < p)
                return false;
            while (n % p == 0) {
                n = n / p;
            }
            return n == 1;
        }
        catch(Exception e) {
            System.out.print("There is an exception: " );
            e.printStackTrace();
            return false;
        }
    }


}




