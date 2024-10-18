package org.simplemedium;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RemoveDuplicatesFromList {

    public static void main(String[] args) {

        List<Tuple> originalList = new ArrayList<>();
        List<Tuple> uniqueList;
        originalList.add(new Tuple(4,5));
        originalList.add(new Tuple(6,1));
        originalList.add(new Tuple(4,5));
        originalList.add(new Tuple(6,1));

        System.out.println("The original list is : " + originalList);

        uniqueList = removeDuplicates(originalList);
        System.out.println("The unique items in the list is : " + uniqueList);
    }

    public static List<Tuple> removeDuplicates(List<Tuple> itemsList) {

        Set<Tuple> uniqueSet = new HashSet<>(itemsList);
        System.out.println(uniqueSet);
        return new ArrayList<>(uniqueSet);
    }
}


class Tuple {
    int x;
    int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }


    @Override
    public int hashCode() {
        int result = Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tuple tuple = (Tuple) obj;
        return x == tuple.x && y == tuple.y;
    }

}
