//Austin Wiant - June 29, 2025 - Module 6 
//This program shows two ways to use bubble sort: 1. Sorting with Comparable 2.Sorting with Comparator

import java.util.Comparator;

public class BubbleSortGenerics {

    // Method 1: Bubble sort using the Comparable interface
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {

            for (int j = 0; j < list.length - 1; j++) {

                // If current element is greater than the next, swap them
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Method 2: Bubble sort using a Comparator object
    public static <E> void bubbleSort(E[] list, Comparator<E> comp) {
        for (int i = 0; i < list.length - 1; i++) {

            for (int j = 0; j < list.length - 1; j++) {

                // Use the Comparator to determine if a swap is needed
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Helper method to print arrays
    public static <E> void printArray(E[] array) {
        for (E item : array) {
            System.out.print(item + " ");
        }
        System.out.println(); // New line after printing the array
    }

    // Main method to test both sorting methods
    public static void main(String[] args) {

        // Test Comparable method with Integer array
        Integer[] numbers = {5, 2, 8, 1, 3};
        System.out.println("Before sorting (Comparable - Integers):");
        printArray(numbers);

        bubbleSort(numbers); // Sort using Comparable
        System.out.println("After sorting (Comparable - Integers):");
        printArray(numbers);

        System.out.println(); // Blank line between tests

        // Test Comparator method with String array
        String[] words = {"Zebra", "Apple", "Lemon", "Banana"};
        System.out.println("Before sorting (Comparator - Strings):");
        printArray(words);

        bubbleSort(words, Comparator.naturalOrder()); // Sort using Comparator
        System.out.println("After sorting (Comparator - Strings):");
        printArray(words);
    }
}
