package org.simplemedium;

import java.util.*;

public class SortHashMapWithObject {

    String FirstName;
    String LastName;
    SortHashMapWithObject(String firstname, String lastname) {
        FirstName = firstname;
        LastName = lastname;
    }

    public String getFirstName() {
        return FirstName;
    }


    public static void main() {
        ArrayList<SortHashMapWithObject> list = new ArrayList<>();
        HashMap<Integer, SortHashMapWithObject> map = new HashMap<>();
        LinkedHashMap<Integer, SortHashMapWithObject> sortedMap = new LinkedHashMap<>();

        SortHashMapWithObject s1 = new SortHashMapWithObject("Minesh", "Bhatiya");
        SortHashMapWithObject s2 = new SortHashMapWithObject("Bina", "Bhatiya");
        SortHashMapWithObject s3 = new SortHashMapWithObject("Raman", "Raghav");
        SortHashMapWithObject s4 = new SortHashMapWithObject("John", "Diego");

        map.put(6, s1);
        map.put(11,s2);
        map.put(9,s3);
        map.put(3,s4);

        for(Map.Entry<Integer, SortHashMapWithObject> imap : map.entrySet()) {
            list.add(imap.getValue());
        }
        System.out.println(list);
        Collections.sort(list,
                new Comparator<SortHashMapWithObject>() {
                    @Override
                    public int compare(SortHashMapWithObject o1, SortHashMapWithObject o2) {
                        return o1.getFirstName().compareTo(o2.getFirstName());
                    }
                });
        System.out.println(list);

        for(Map.Entry<Integer, SortHashMapWithObject> imap2 : map.entrySet()) {
            //if
        }


//        Comparator<SortHashMapWithObject> byName = (SortHashMapWithObject obj1, SortHashMapWithObject obj2) -> obj1.getFirstName().compareTo(obj2.getFirstName());



    }
}
