package org.simplemedium;

public class Fibbonacci {
    public static void main(String[] args) {
        printFirstFibbonacci(10);
    }

    public static void printFirstFibbonacci(int n) {

        System.out.println(0);
        System.out.println(1);

        int prev = 0;
        int curr = 1;
        int fibb;

        for(int i=0; i < n; i++){
            fibb = prev+curr;
            System.out.println(fibb);
            prev = curr;
            curr = fibb;
        }
    }
}
