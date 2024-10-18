package org.complex;

import java.util.Arrays;

/**
 * "Given an array of n integers where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that:
 *
 * Each student gets one packet.
 * The difference between the number of chocolates in the packet with maximum chocolates and packet with minimum chocolates given to the students is minimum."
 */
public class ChocolateDistributionProblem {

    public static void main(String[] args) {
        int[] chocolates = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7; // Number of students

        int minDifference = findMinDifference(chocolates, m);

        System.out.println("Minimum difference is " + minDifference);
    }

    public static int findMinDifference(int[] chocolates, int m) {
        if (m == 0 || chocolates.length == 0) {
            return 0;
        }

        // Sort the array
        Arrays.sort(chocolates);

        if (chocolates.length < m) {
            return -1; // Not enough packets for the students
        }

        int minDiff = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(chocolates));
        // Find the minimum difference
        for (int i = 0; i + m - 1 < chocolates.length; i++) {
            int diff = chocolates[i + m - 1] - chocolates[i];
            System.out.println(i +" - " + chocolates[i + m - 1] +" - " + chocolates[i] + " | " + diff);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }
}

