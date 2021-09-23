package StreamsFilesAndDirectories;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyBytes {

    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader("D:\\Files-and-Streams\\debug.txt");

        FileWriter writer = new FileWriter("D:\\Files-and-Streams\\input.txt");

        String current = String.valueOf(reader.read());
        while (!current.equals("-1")) {

            if (current.equals("32") || current.equals("10")) {
                writer.write(Integer.parseInt(current));
            } else {
                writer.write(current);
            }

            current = String.valueOf(reader.read());
        }
        writer.close();
    }
}
