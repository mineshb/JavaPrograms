package org.simplemedium;

import java.util.ArrayList;
import java.util.List;

/*
4. Find Prime fraction of a number
    if no. Is 6 prime fraction is 2,3
    If no. Is 24 then prime fraction is 2,2,2,3
    If no. Is negative or 1
    then there is no fraction it should be empty
 */
public class FindPrimeFractionOfNumber {

    public static void main(String[] args) {
        int num = 152;
        List<Integer> result = findPrimeFraction(num);
        System.out.println(result);
    }

    public static List<Integer> findPrimeFraction(int inputNum) {
        List<Integer> primeFactors = new ArrayList<>();

        if(inputNum < 1){
            return primeFactors;
        }

        while(inputNum %2 == 0) {
            primeFactors.add(2);
            inputNum /= 2;
        }

        for(int i = 3; i < Math.sqrt(inputNum); i = i+2){
            while(inputNum % i == 0) {
                inputNum = inputNum/i;
                primeFactors.add(i);
            }
        }

        if(inputNum > 2) {
            primeFactors.add(inputNum);
        }

        return primeFactors;
    }


}
