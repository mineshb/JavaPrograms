package org.simplemedium;

public class SecondSmallestNumber {

    public static void main(String[] args) {
        int[] arr = {-1,-10,20,42,-13,0,100};
        findSecondSmallestNumber(arr);
        findSecondLargestNumber(arr);

    }

    public static void findSecondSmallestNumber(int[] arr) {

        if(arr.length < 2) {
            System.out.println("Array should have at least two elements");
            return;
        }

        int smallestNum = Integer.MAX_VALUE;
        int secondSmallestNum = Integer.MAX_VALUE;
        int tmp;

        for (int num : arr) {
            if(num < smallestNum) {
                secondSmallestNum = smallestNum;
                smallestNum = num;
            }
            else if(num > smallestNum && num < secondSmallestNum ) {
                secondSmallestNum = num;
             }
        }

        if (secondSmallestNum == Integer.MAX_VALUE) {
            System.out.println("There is no second smallest element");
        } else {
            System.out.println("The second smallest element is " + secondSmallestNum);
        }

    }

    public static void findSecondLargestNumber(int[] arr) {

        if(arr.length < 2) {
            System.out.println("Array should have at least two elements");
            return;
        }

        int largestNum = Integer.MIN_VALUE;
        int secondLargestNum = Integer.MIN_VALUE;

        for (int num : arr) {
            if(num > largestNum) {
                secondLargestNum = largestNum;
                largestNum = num;
            }
            else if(num < largestNum && num > secondLargestNum ) {
                secondLargestNum = num;
            }
        }

        if (secondLargestNum == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element");
        } else {
            System.out.println("The second largest element is " + secondLargestNum);
        }

    }
}
