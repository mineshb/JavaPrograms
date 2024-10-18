package org.simplemedium;

public class Temp {

    public static void main(String[] args) {
        printFibonaaci(5);
    }

    public static void printFibonaaci(int n) {
        // 0 1 1 2 3 5
        int prev =0;
        int current=0;
        int next=1;
        for (int i = 1; i <=n; i++) {
            current = prev+next;
            System.out.println(current);
            next = prev;
            prev = current;
        }

    }
}
