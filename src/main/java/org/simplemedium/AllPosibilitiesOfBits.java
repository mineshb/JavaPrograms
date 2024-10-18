package org.simplemedium;

import java.util.ArrayList;
import java.util.List;

public class AllPosibilitiesOfBits {

    public static void main(String[] args) {
        int len = 2;
        List<String> intList = new ArrayList<>();
        generator(len, "", intList);
        System.out.println(intList.toString());
    }

    public static void generator(int len, String prefix, List<String> numbersList) {
        if(len == 0) {
            //System.out.println(numbersList.toString());
            numbersList.add(prefix);
            return ;
        }

        generator(len-1, prefix + "0", numbersList);
        generator(len-1, prefix + "1", numbersList);
    }

}
