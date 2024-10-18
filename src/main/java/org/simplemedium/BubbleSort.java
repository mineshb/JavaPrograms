package org.simplemedium;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] inputArr) {
        int temp;
        int ln = inputArr.length;
        boolean swapped = false;
        for(int i =0; i<ln-1; i++) {
            swapped = false;
            for(int j=0; j < ln - 1 - i; j++) {
                if(inputArr[j] > inputArr[j+1]) {
                    // Swap Elements
                    temp = inputArr[j];
                    inputArr[j] = inputArr[j+1];
                    inputArr[j+1] = temp;
                    swapped = true;

                    System.out.println(Arrays.toString(inputArr));
                }
            }
            if(!swapped)
                break;
        }
        return inputArr;
    }


    public static void main(String[] args) {
        int[] inputArr = {5,32,8,2,4,1};
        int[] outputArr;

        outputArr = bubbleSort(inputArr);
        for (int i : outputArr) {
            System.out.print(i + " ");
        }
    }
}
