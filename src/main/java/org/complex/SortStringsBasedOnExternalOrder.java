package org.complex;
import java.util.*;

/*
24. Problem Statement:
*
*Given a list of Strings, and an external order in which it needs to be sorted, Sort the given list of *strings.
*For example:
*Input Strings :  ""Ajay"", ""Raja"", ""Keshav"", ""List"", ""Set"", ""Elephant"", ""Drone""
*Sort order:  TESARDLK
*Sorted Strings: ""Elephant"", ""Set"",""Ajay"", ""Raja"", ""Drone"",""List"",""Keshav""
 */
public class SortStringsBasedOnExternalOrder {

    public static void main(String[] args) {
        String[] inputStrList = {"Ajay", "Raja", "Keshav", "List", "Tesla", "Set", "Elephant", "Drone" };
        String externalSortOrder = "TESARDLK";
        String[] resultStrings = sortStringsInExternalOrder(inputStrList, externalSortOrder);
        for(String str: resultStrings) {
            System.out.println(str);
        }
    }

    public static String[]  sortStringsInExternalOrder(String[] inputList, String order) {
        SortStringsBasedOnExternalOrder solution = new SortStringsBasedOnExternalOrder();
        CustomComparator myComparator = solution.new CustomComparator(order);
        Arrays.sort(inputList, myComparator);
        return inputList;
    }


     class CustomComparator implements Comparator<String> {
        Map<Character, Integer> orderMap;
        String customOrder;

        public CustomComparator(String customOrder) {
            this.customOrder = customOrder;
            initialize();
        }

        public void initialize() {
            orderMap = new HashMap<>();
            for(int i=0; i < customOrder.length(); i++) {
                orderMap.put(customOrder.charAt(i),i);
            }
        }
        @Override
        public int compare(String o1, String o2) {
            int minLen = Math.min(o1.length(), o2.length());
            for (int i =0; i<minLen; i++) {
                char c1 = o1.charAt(i);
                char c2 = o2.charAt(i);
                int index1 = orderMap.getOrDefault(c1, -1);
                int index2 = orderMap.getOrDefault(c2, -2);
                if(index1 != index2) {
                    return Integer.compare(index1, index2);
                }
            }
            return Integer.compare(o1.length(), o2.length());
        }
    }


}
