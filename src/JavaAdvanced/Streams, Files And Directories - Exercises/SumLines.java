package StreamsFilesAndDirectories;

import java.io.*;

public class SumLines {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
            String line = reader.readLine();
            while (line != null) {

                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }

                writer.write(sum + "");
                writer.newLine();
                line = reader.readLine();
            }
            writer.close();

        } catch (IOException a) {

        }

    }
}
