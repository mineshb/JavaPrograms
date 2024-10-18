package org.complex.extra;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

public class Temp {

    public static void main(String[] args) {
        Integer[] input = {2, 3, 5, 6, 8, 9 , 12, 14, 17};
        List<Integer> tmp =  Arrays.asList(input);
        System.out.println(tmp);

        Integer result = tmp.stream().filter(n -> n % 2 ==0).mapToInt(Integer::intValue).sum();
        System.out.println(result);

        List<String> list = Arrays.asList(new String[]{"Cat", "doG", "COw"});
        //String finalResult = list.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        //String finalResult = list.stream().map(Temp::ABC).collect(Collectors.joining(","));
        //System.out.println(finalResult);
    }

    public static void ABC() {
        System.out.println("ABC");
    }



    public static void moveNegativeAndPositiveVals() {
        int[] input = {-12, 5, 7, -9,  45, 23, -4, -3};
        int len = input.length;
        int[] result = new int[len];

        int l =0;
        int r = len-1;
        int i =0;
        while(i < (len-1)) {
            if(input[i] < 0) {
                result[l++] = input[i];
            }
            else {
                result[r--] = input[i];

            }
            i++;
            System.out.println(Arrays.toString(result));
        }
    }
}
