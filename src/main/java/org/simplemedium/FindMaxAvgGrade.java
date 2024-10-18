package org.simplemedium;

import java.util.HashMap;
import java.util.Map;

/*
8. For a given input 2D array of strings, find the maximum average grade, round off to the nearest floor integer.

Input : {"Rohit", "85"},
 {"Rahul", "80"},
 {"Amit","85"},
 {"Rohit", "90"} }

Output : 87
Logic : Rohit's average grade is (85+90)/2 = 87.5  which when rounded off to floor is  87
 */
public class FindMaxAvgGrade {
    public static void main(String[] args) {
        String[][] inputArr = {
                {"Rohit", "86"},
                {"Rahul", "80"},
                {"Amit","88"},
                {"Rohit", "90"},
                {"Rohit", "92"},
                {"Amit","98"}
        };

        Map<String, Integer> mapStudentGrade = findAverage(inputArr);
        System.out.println("Final Result " + mapStudentGrade);

        Integer maxGrade = mapStudentGrade.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
        System.out.println("Max Grade " + maxGrade);

        // Alternative
        int maxValue = 0;
        for(Map.Entry<String, Integer> map: mapStudentGrade.entrySet() ) {
            if(map.getValue() > maxValue) {
                maxValue = map.getValue();
            }
        }
        System.out.println("Max Grade  " + maxValue);
    }

    public static Map<String, Integer> findAverage(String[][] inputArr) {
        Map<String, Integer> resultMap = new HashMap<>();

        for(String[] str : inputArr) {
            resultMap.merge(str[0], Integer.parseInt(str[1]), (g1,g2)-> (g1+g2)/2);
        }

        return resultMap;
    }

}
