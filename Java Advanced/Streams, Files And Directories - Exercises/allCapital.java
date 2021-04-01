package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class allCapital {

    public static void main(String[] args) {
        try {

            FileInputStream reader = new FileInputStream("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
            FileOutputStream writer = new FileOutputStream("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
            int a = reader.read();
            StringBuilder line = new StringBuilder();

            while (a != -1) {

                while (a != '\n' && a != -1) {
                    line.append((char) a);
                    a = reader.read();
                }

                a = reader.read();

                line = new StringBuilder(line.toString().toUpperCase());

                for (int i = 0; i < line.length(); i++) {
                    writer.write(line.charAt(i));
                }

                line = new StringBuilder();
            }

            writer.close();
        } catch (IOException ignored) {

        }

    }
}
