// Author: Austin Wiant - Date: 06/22/2025
// Assignment: Read non-duplicate words from a file, sort ascending and descending

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SimpleWordSorter {
    public static void main(String[] args) {
        String fileName = "collection_of_words.txt";
        Set<String> wordSet = new TreeSet<>(); // TreeSet stores words in sorted order

        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNext()) {
                String word = input.next().toLowerCase().replaceAll("[^a-z]", "");
                if (!word.isEmpty()) {
                    wordSet.add(word); // duplicates are ignored
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return;
        }

        // Ascending order (TreeSet is already sorted)
        System.out.println("Ascending order:");
        for (String word : wordSet) {
            System.out.println(word);
        }

        // Descending order
        System.out.println("\nDescending order:");
        List<String> wordList = new ArrayList<>(wordSet);
        Collections.reverse(wordList);
        for (String word : wordList) {
            System.out.println(word);
        }
    }
}

