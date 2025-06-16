// Name: Austin Wiant - 6/15/2025 - Assignment: Module 3 Programming Assignment 
// Purpose: Compare the time it takes to traverse a LinkedList using an iterator vs. using get(index)

import java.util.LinkedList;
import java.util.Iterator;

public class wiant_assignment4 {

    public static void main(String[] args) {
        // Run traversal timing test for both 50,000 and 500,000 elements
        testLinkedListTraversal(50_000);
        testLinkedListTraversal(500_000);
    }

    /**
     * Populates a LinkedList with the given number of integers, then times and prints how long it takes to traverse it using both an iterator and the get(index) method.
     * @param size the number of elements to test with
     */
    
    public static void testLinkedListTraversal(int size) {
        // Create and populate the LinkedList
        LinkedList<Integer> numberList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            numberList.add(i);
        }

        System.out.println("\nTesting traversal with " + size + " elements:");

        // Traverse using an iterator (efficient for LinkedList)
        long startTime = System.nanoTime();
        for (Iterator<Integer> iterator = numberList.iterator(); iterator.hasNext(); ) {
            iterator.next();
        }
        long iteratorDuration = System.nanoTime() - startTime;
        System.out.println("Iterator traversal time: " + iteratorDuration / 1_000_000.0 + " ms");

        // Let the user know that the get(index) test is starting
        System.out.println("Starting get(index) traversal...");

        // Traverse using get(index) (inefficient for LinkedList)
        startTime = System.nanoTime();
        for (int i = 0; i < numberList.size(); i++) {
            numberList.get(i);  // Slower: has to traverse from head each time
        }
        long getDuration = System.nanoTime() - startTime;
        System.out.println("get(index) traversal time: " + getDuration / 1_000_000.0 + " ms");
    }
}