package org.complex;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 7. Little girl has 5 ten rupee coins, 10 two rupee coins and 50 five rupee coins.
 * The needs 50 rupees out of this. W
 * rite a program to find all possible ways the girl can make 50 rupees.
 */
public class CoinCombination {
    // Constants representing the values of the coins
    private static final int TEN_RUPEE = 10;
    private static final int TWO_RUPEE = 2;
    private static final int FIVE_RUPEE = 5;

    // Constants representing the number of each type of coin
    private static final int TEN_RUPEE_COUNT = 5;
    private static final int TWO_RUPEE_COUNT = 10;
    private static final int FIVE_RUPEE_COUNT = 50;

    public static void main(String[] args) {
        // Set to store all the unique combinations
        Set<List<Integer>> result = new LinkedHashSet<>();

        // Call the recursive function
        findCombinations(result, new ArrayList<>(), 0, 0, 0, 50);

        // Print all combinations
        for (List<Integer> combination : result) {
            System.out.println("10-Rupee Coins: " + combination.get(0) +
                    ", 5-Rupee Coins: " + combination.get(1) +
                    ", 2-Rupee Coins: " + combination.get(2));
        }
    }

    public static void findCombinations(Set<List<Integer>> result, List<Integer> current,
                                        int tenCount, int fiveCount, int twoCount, int target) {

        // Calculate the total value with the current counts of each coin
        int total = tenCount * TEN_RUPEE + fiveCount * FIVE_RUPEE + twoCount * TWO_RUPEE;

        // If the total equals the target, add the combination to the result set
        if (total == target) {
            List<Integer> combination = new ArrayList<>();
            combination.add(tenCount);
            combination.add(fiveCount);
            combination.add(twoCount);
            result.add(combination);
            return;
        }

        // If the total exceeds the target, return
        if (total > target) {
            return;
        }

        // Explore further combinations by incrementing the count of each type of coin
        if (tenCount < TEN_RUPEE_COUNT) {
            findCombinations(result, current, tenCount + 1, fiveCount, twoCount, target);
        }
        if (fiveCount < FIVE_RUPEE_COUNT) {
            findCombinations(result, current, tenCount, fiveCount + 1, twoCount, target);
        }
        if (twoCount < TWO_RUPEE_COUNT) {
            findCombinations(result, current, tenCount, fiveCount, twoCount + 1, target);
        }
    }
}
