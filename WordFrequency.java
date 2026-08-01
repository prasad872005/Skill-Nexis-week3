2. File I/O Assignment
Read from a text file, count word frequency, and write output to another file

import java.io.*;
import java.util.*;

public class WordFrequency {

    public static void main(String[] args) {

        HashMap<String, Integer> wordCount = new HashMap<>();

        try {
            // Read from input file
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            reader.close();

            // Write to output file
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }

            writer.close();

            System.out.println("Word frequency has been written to output.txt");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
