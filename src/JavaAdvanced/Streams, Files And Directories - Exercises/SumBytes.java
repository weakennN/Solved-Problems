package StreamsFilesAndDirectories;

import java.io.*;

public class SumBytes {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

            String line = reader.readLine();
            long sum = 0;
            while (line != null) {

                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }

                line = reader.readLine();
            }

            writer.write(String.valueOf(sum));
            writer.close();
        } catch (IOException ignored) {

        }
    }
}
