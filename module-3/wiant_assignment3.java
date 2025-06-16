// Name: Austin Wiant - Date: J6/15/2025 - Assignment: Module 3 Programming Assignment 
// Purpose: Generate an ArrayList with 50 random integers (1–20) and return a new ArrayList with duplicates removed.

import java.util.ArrayList;
import java.util.Random;

public class wiant_assignment3 {

    public static void main(String[] args) {
        // Generate a list of 50 random integers
        ArrayList<Integer> originalList = generateRandomList(50, 1, 20);

        System.out.println("Original List:");
        System.out.println(originalList);

        // Remove duplicates from original list
        ArrayList<Integer> noDuplicates = removeDuplicates(originalList);

        System.out.println("\nList After Removing Duplicates:");
        System.out.println(noDuplicates);
    }

    /**
     * Generates a list of random integers.
     * @param count Number of integers to generate
     * @param min Minimum value (inclusive)
     * @param max Maximum value (inclusive)
     * @return ArrayList of random integers
     */

    public static ArrayList<Integer> generateRandomList(int count, int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            list.add(rand.nextInt(max - min + 1) + min);
        }
        return list;
    }

    /**
     * Returns a new ArrayList with duplicates removed from the input list.
     * @param list Input ArrayList with possible duplicates
     * @param <E> Type parameter 
     * @return ArrayList without duplicate elements
     */

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
