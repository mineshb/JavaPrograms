package org.simplemedium;

import java.util.Arrays;

/*
12. Find the median of two sorted arrays of different size.
Example:
Input :
Array 1: 2 3 6 7 9
Array 2: -1 4 8 10  = 5
Output : 6
Hint: The final sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10 The 5th element of this array is 6.
 */
public class MedianOfSortedArray {

    public static void main(String[] args) {
        int[] num1 = {2, 3, 6, 7, 9};
        int[] num2 = {-1, 4, 8 ,10};
        System.out.println("The median is " + findMedianFromArr(mergeArray(num1, num2)));
    }

    private static int[] mergeArray(int[] nums1, int[] nums2) {
        int[] mergedArr = new int[nums1.length+ nums2.length];

        int k =0;
        for(int n1 =0; n1 < nums1.length; n1++) {
            System.out.println("The length is " + nums1[n1]);
            mergedArr[k++] = nums1[n1];

        }

        for(int n2 =0; n2 < nums2.length; n2++) {
            mergedArr[k++] = nums2[n2];
        }
        Arrays.sort(mergedArr);
        return mergedArr;
    }

    private static int findMedianFromArr(int[] nums) {
        int median = 0;
        median  = nums.length / 2;
        if(nums.length % 2 ==0)
            return nums[median];
        else {
            return (nums[median] + nums[median+1])/2;
        }
    }
}
