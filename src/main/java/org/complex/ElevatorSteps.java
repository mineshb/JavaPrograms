package org.complex;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSteps {

    public static void main(String[] args) {
        int n = 7; // Example step number
        List<Integer> steps = new ArrayList<>();
        findPaths(0, n, steps);
    }

    public static void findPaths(int currentStep, int targetStep, List<Integer> steps) {
        if (currentStep == targetStep) {
            System.out.println(steps);
            return;
        }

        if (currentStep > targetStep) {
            return;
        }

        int lastStepSize = steps.isEmpty() ? 0 : steps.get(steps.size() - 1);

        // Try starting with 1 or 2 steps initially
        if (lastStepSize == 0) {
            for (int i = 1; i <= 2; i++) {
                steps.add(i);
                findPaths(currentStep + i, targetStep, steps);
               // System.out.println("Executing If condition" +  steps);
                steps.remove(steps.size() - 1);
            }
        } else {
            // Continue with the current step pattern
            for (int i = lastStepSize; i <= lastStepSize + 2; i++) {
                steps.add(i);
                findPaths(currentStep + i, targetStep, steps);
              //  System.out.println("Executing Else condition" + steps);
                steps.remove(steps.size() - 1);
            }
        }
    }
}
