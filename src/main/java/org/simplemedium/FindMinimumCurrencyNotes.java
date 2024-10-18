package org.simplemedium;

/*
23. You have 2 currency notes {100,500}.
	    We need to make Rs 1200 out of these notes. How many minimum notes required to get rs 1200.
 */

public class FindMinimumCurrencyNotes {
    public static void main(String[] args) {
        int amount = 1200;
        int[] notes = {500, 100}; // Denominations available

        int minNotes = getMinimumNotes(amount, notes);
        System.out.println("Minimum number of notes required: " + minNotes);
    }

    public static int getMinimumNotes(int target, int[] notes) {
        int count = 0;
        // Use the largest denomination first
        for (int i = 0; i < notes.length; i++) {
            int note = notes[i];
            count += target / note; // Number of notes of this denomination
            target %= note; // Remaining amount
        }

        return count;
    }
}

