package StreamsFilesAndDirectories;

import java.io.*;

public class CountCharacterTypes {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

            String line = reader.readLine();

            int vowelsCount = 0;
            int punctuationCount = 0;
            int consonantsCount = 0;
            String punctuation = ",!?.";
            String vowels = "aeiou";

            while (line != null) {

                for (int i = 0; i < line.length(); i++) {

                    if (line.charAt(i) != ' ') {

                        if (vowels.contains(line.charAt(i) + "")) {
                            vowelsCount++;
                        } else if (punctuation.contains(line.charAt(i) + "")) {
                            punctuationCount++;
                        } else {
                            consonantsCount++;
                        }
                    }
                }
                line = reader.readLine();
            }

            writer.write("Vowels: " + vowelsCount + "" + "\n");
            writer.write("Consonants: " + consonantsCount + "" + "\n");
            writer.write("Punctuation: " + punctuationCount + "");
            writer.close();

        } catch (IOException ignored) {

        }
    }
}
