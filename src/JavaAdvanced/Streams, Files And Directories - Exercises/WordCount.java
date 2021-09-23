package StreamsFilesAndDirectories;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
            BufferedReader finalReader = new BufferedReader(new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
            Map<String, Integer> wordsCount = new LinkedHashMap<>();
            String line = reader.readLine();
            String word = "";

            for (int i = 0; i < line.length(); i++) {

                if (line.charAt(i) == ' ') {
                    wordsCount.put(word, 0);
                    word = "";
                } else {
                    word += line.charAt(i);
                }
            }

            wordsCount.put(word, 0);
            line = finalReader.readLine();
            String[] words = line.split("[, ]");

            for (int i = 0; i < words.length; i++) {
                if (wordsCount.containsKey(words[i])) {
                    wordsCount.put(words[i], wordsCount.get(words[i]) + 1);
                }
            }

            wordsCount.entrySet().stream().sorted((l, r) -> r.getValue().compareTo(l.getValue()))
                    .forEach(e -> {
                        try {
                            writer.write(e.getKey() + " - " + e.getValue() + '\n');
                        } catch (IOException ioException) {

                        }
                    });

            writer.close();
        } catch (IOException ignored) {

        }
    }
}
