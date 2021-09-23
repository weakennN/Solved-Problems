package StreamsFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoFiles {

    public static void main(String[] args) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
            List<String> list = new ArrayList<>();

            read(reader, list);
            read(reader2, list);

            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i) + '\n');
            }

            writer.close();

        } catch (IOException ignored) {

        }

    }

    public static void read(BufferedReader reader, List<String> read) {

        try {
            String line = reader.readLine();

            while (line != null) {
                read.add(line);
                line = reader.readLine();
            }

        } catch (IOException e) {

        }

    }

}
