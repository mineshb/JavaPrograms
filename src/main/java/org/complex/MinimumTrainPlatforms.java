package org.complex;

import java.util.Arrays;

public class MinimumTrainPlatforms {

    public static void main(String[] args) {
        String[] arr = {"09:00", "09:40", "09:50", "11:00", "15:00", "18:00"};
        String[] dep = {"09:10", "12:00", "11:20", "11:30", "19:00", "20:00"};

        int result = findMinimumPlatforms(arr, dep);
        System.out.println("Minimum number of platforms required: " + result);
    }

    public static int findMinimumPlatforms(String[] arr, String[] dep) {
        // Convert time strings to minutes since midnight for easier comparison
        int[] arrival = new int[arr.length];
        int[] departure = new int[dep.length];

        for (int i = 0; i < arr.length; i++) {
            arrival[i] = convertToMinutes(arr[i]);
            departure[i] = convertToMinutes(dep[i]);
        }

        // Sort both arrays
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platformsNeeded = 0;
        int maxPlatforms = 0;
        int i = 0, j = 0;

        // Use two pointers to traverse the arrival and departure arrays
        while (i < arrival.length && j < departure.length) {
            if (arrival[i] < departure[j]) {
                platformsNeeded++;
                i++;
                if (platformsNeeded > maxPlatforms) {
                    maxPlatforms = platformsNeeded;
                }
            } else {
                platformsNeeded--;
                j++;
            }
        }

        return maxPlatforms;
    }

    public static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}