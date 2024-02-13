// Write a Java Program that reads a large text document, 
// processes the data using Java streams and file handling, 
// and provides Word Frequency Analysis. 
// The program must :  Read the text file using Java streams , 
//                     Tokenize the text into words, 
//                     use streams to count the frequency of each word 
//                     & display the top N most frequent words.

package advJava.labPractice.TW1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class javaStreams {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> wordFreq = new HashMap<>();

        try (InputStream file = new FileInputStream("advJava\\labPractice\\TW1\\text.txt")) {
            StringBuilder word = new StringBuilder();
            int c;

            while ((c = file.read()) != -1) {
                // System.out.print((char) c);

                if (Character.isWhitespace(c)) {
                    // System.out.println("Space");

                    String currentWord = word.toString().toLowerCase();
                    if (!currentWord.isEmpty()) {
                        wordFreq.put(currentWord, wordFreq.getOrDefault(currentWord, 0) + 1);
                    }

                    word.setLength(0); // Reset the StringBuilder for the next word
                } else {
                    word.append((char) c);
                }
            }

            // Check for the last word
            String lastWord = word.toString().toLowerCase();
            if (!lastWord.isEmpty()) {
                wordFreq.put(lastWord, wordFreq.getOrDefault(lastWord, 0) + 1);
            }
        }

        System.out.println("Top frequent words:");
        findNFrequentWord(wordFreq);

        // System.out.println("Word frequencies:");
        // System.out.println(wordFreq);

        // String mostFrequentWord = findMostFrequentWord(wordFreq);
        // System.out.println("Most frequent word: " + mostFrequentWord);
    }

    private static void findNFrequentWord(Map<String, Integer> wordFreq) {
        // Sort the HashMap by value
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordFreq.entrySet());
        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        System.out.println("\nSorted HashMap by value:");
        // Iterate through the sorted List and print the keys
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String findMostFrequentWord(Map<String, Integer> wordFreq) {
        String mostFrequentWord = "";
        int maxFrequency = 0;

        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }

        return mostFrequentWord;
    }
}
