package org.simplemedium;

import java.util.ArrayList;
import java.util.List;

/**
Given an unsorted array A of size N, find a continuous sub-array which  sums up to S.
For example if the input array is [ 12,7,29,6, 2, 11,4,8] and the  expected sum is 8, then there are two possibilities [6,2] and [8]
if the expected sum is 19 there are two possibilities [12,7] and [6,2,11].  [11,8] is not a possibility since its not continuous.
 */
public class FindSubArrayMatchingSumWithGivenInput {

    public static void main(String[] args) {
        int[] arr = {12,7,29,6, 2, 11,4,8};
        int targetSum = 19;

        List<List<Integer>> result = findSubsetWithMatchingSumImproved(arr, targetSum);
        System.out.println("Subset with matching sum " + targetSum + " :: ");
        for(List<Integer> lst : result) {
            System.out.println(lst);
        }
    }

    public static List<List<Integer>> findSubsetWithMatchingSum(int[] arr, int targetSum) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int j =0, previous = 0;
        while (j < arr.length) {
            if((previous+arr[j]) == targetSum) {
                tempList.add(arr[j]);
                resultList.add(tempList);
                tempList = new ArrayList<>();
                previous = 0;
           }
            else if((previous+arr[j]) > targetSum) {
                if (previous > 0) {
                    previous = previous - tempList.get(0);
                }
                if(tempList.size() > 0) {
                    tempList.remove(tempList.get(0));
                }
            }
            else if((previous+arr[j]) < targetSum) {
                tempList.add(arr[j]);
                previous += arr[j];
            }
            j++;
        }

        return resultList;

    }

    public static List<List<Integer>> findSubsetWithMatchingSumImproved(int[] arr, int targetSum) {
        List<List<Integer>> resultList = new ArrayList<>();
        int start = 0, end = 0, sum = 0;

        while (end < arr.length) {
            sum += arr[end];

            while (sum > targetSum && start <= end) {
                sum -= arr[start];
                start++;
            }

            if (sum == targetSum) {
                List<Integer> tempList = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    tempList.add(arr[i]);
                }
                resultList.add(tempList);
            }
            end++;
        }
        return resultList;
    }

}
