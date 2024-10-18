package org.HackerRank;

import java.io.*;
import java.util.*;

public class StdInOut {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
     /*   Scanner scanner = new Scanner(System.in);
        int myInt = scanner.nextInt();
        double myDbl = scanner.nextDouble();
        String myStr = scanner.nextLine();
        scanner.close();

        System.out.println("String: " + myStr);
        System.out.println("Double: " + myDbl);
        System.out.println("Int: " + myInt);*/

/*

        Scanner scanner = new Scanner(System.in);
        String firstStr = scanner.next();
        int firstInt = scanner.nextInt();
        String secondStr = scanner.next();
        int secondInt = scanner.nextInt();
        String thirdStr = scanner.next();
        int thirdInt = scanner.nextInt();

        System.out.printf("%-15s", firstStr);
        System.out.printf("%03d", firstInt);
        System.out.println();
        System.out.printf("%-15s", secondStr);
        System.out.printf("%03d", secondInt);
        System.out.println();
        System.out.printf("%-15s", thirdStr);
        System.out.printf("%03d", thirdInt);
*/

/*        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i=1; i<=10; i++) {
            System.out.println(n + " x " + i + " = " + (n*i));
        }

        bufferedReader.close();*/

       /* Scanner scanner = new Scanner(System.in);
        int nLines = scanner.nextInt();
        scanner.nextLine();

        int[] a = new int[nLines];
        int[] b = new int[nLines];
        int[] n = new int[nLines];

        for(int i =0; i<nLines; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            n[i] = scanner.nextInt();
            scanner.nextLine();
        }
        scanner.close();

        for(int k =0; k<nLines; k++) {
            printOut(a[k], b[k], n[k]);
        }*/

        /*Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        List<String> results = new ArrayList<>(); // store results

        for (int i = 0; i < t; i++) {
            try {
                long num = scanner.nextLong(); // reading the input number
                StringBuilder result = new StringBuilder(num + " can be fitted in:\n");

                // Check for byte (-128 to 127)
                if (num >= Byte.MIN_VALUE && num <= Byte.MAX_VALUE) {
                    result.append("* byte\n");
                }
                // Check for short (-32,768 to 32,767)
                if (num >= Short.MIN_VALUE && num <= Short.MAX_VALUE) {
                    result.append("* short\n");
                }
                // Check for int (-2^31 to 2^31 - 1)
                if (num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE) {
                    result.append("* int\n");
                }
                // Check for long (-2^63 to 2^63 - 1)
                if (num >= Long.MIN_VALUE && num <= Long.MAX_VALUE) {
                    result.append("* long\n");
                }

                results.add(result.toString()); // add to results list

            } catch (Exception e) {
                // If the number exceeds the long range
                results.add(scanner.next() + " can't be fitted anywhere.\n");
            }
        }

        scanner.close();

        // Output all results
        for (String result : results) {
            System.out.print(result);
        }*/

        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>(); // List to store all lines

        // Scan all input lines and store them in the list
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line); // Store each line in the list
        }

        scanner.close(); // Close the scanner

        // Now print all lines with their line numbers
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + " " + lines.get(i)); // Print with line number
        }


    }

    public static void printOut(int a, int b, int n) {
        int res = a;
        for(int j = 0; j < n;j ++) {
            res = (int)(res + (Math.pow(2, j)*b));
            System.out.print(res + " ");
        }
        System.out.println();
    }
}