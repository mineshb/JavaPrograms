package org.simplemedium;


import java.util.Arrays;
        import java.util.List;
        import java.util.Map;
        import java.util.stream.Collectors;

/**
 * 21. Java 8:  List<Integer> numbers= Arrays.asList(1,43,15,66,87,89,9,10,22,34,23,89,54);
 *
 *    // Java 8
 *    // 1. get only single digit number
 *    //2.  {even: evennumber, odd: oddnumbers}
 *    //3. get all prime numbers
 */
public class Java8ArrayProblem {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 43, 15, 66, 87, 89, 9, 10, 22, 34, 23, 89, 54);

        // 1. Get only single-digit numbers
        List<Integer> singleDigitNumbers = numbers.stream()
                .filter(n -> n / 10 == 0)
                .collect(Collectors.toList());
        System.out.println("Single-digit numbers: " + singleDigitNumbers);

        // 2. Group numbers into even and odd
        Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even numbers: " + partitionedNumbers.get(true));
        System.out.println("Odd numbers: " + partitionedNumbers.get(false));

        // 3. Get all prime numbers
        List<Integer> primeNumbers = numbers.stream()
                .filter(Java8ArrayProblem::isPrime)
                .collect(Collectors.toList());
        System.out.println("Prime numbers: " + primeNumbers);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i=2; i <= number/2; i++) {
            if(number % i ==0)
                return false;
        }
        return true;

        /*return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .allMatch(n -> number % n != 0);*/
    }
}
