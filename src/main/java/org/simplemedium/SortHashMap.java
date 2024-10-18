package org.simplemedium;

import java.util.*;

public class SortHashMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        LinkedHashMap<String, String> sortedMap = new LinkedHashMap<>();
        ArrayList<String> list = new ArrayList<>();
        map.put("2", "B");
        map.put("8", "A");
        map.put("4", "D");
        map.put("7", "F");
        map.put("6", "W");
        map.put("19", "J");
        map.put("1", "Z");
        for(Map.Entry<String, String> iMap : map.entrySet()) {
            list.add(iMap.getValue());
        }
        System.out.println(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);

        for(String str: list) {
            for(Map.Entry<String, String> iMap2 : map.entrySet()) {
                if(iMap2.getValue().equals(str)) {
                    sortedMap.put(iMap2.getKey(), iMap2.getValue());
                }
            }
        }

        System.out.println("Original " + map);
        System.out.println("Sorted " + sortedMap);

    }



 }
