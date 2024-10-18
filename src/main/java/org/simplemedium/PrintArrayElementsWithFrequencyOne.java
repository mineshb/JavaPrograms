package org.simplemedium;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintArrayElementsWithFrequencyOne {

    public static void main(String[] args) {

        PrintWithFrequencyOne(new int[]{-1, -2, 3, 3, -2});
        Scanner scan = new Scanner(System.in);


    }

    public static void PrintWithFrequencyOne(int[] inputArr) {
        Map<Integer, Integer> uniqueElements = new HashMap<>();
        for(int i = 0; i< inputArr.length; i++) {
            uniqueElements.put(inputArr[i], uniqueElements.getOrDefault(inputArr[i],0)+1);
        }
        System.out.println(uniqueElements);

        System.out.println("UniqueValues");
        for(Map.Entry<Integer, Integer> map : uniqueElements.entrySet()) {

            if(map.getValue() == 1) {
                System.out.println(map.getKey());
            }
        }
    }
}
