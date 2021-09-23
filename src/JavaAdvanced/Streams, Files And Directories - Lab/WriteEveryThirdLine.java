package StreamsFilesAndDirectories;

import java.io.*;

public class WriteEveryThirdLine {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("D:\\Files-and-Streams\\ex1.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("D:\\Files-and-Streams\\input.txt"));

        int counter = 1;

        while (reader.read() != -1) {

            String a = reader.readLine();
            char b = (char) reader.read();
            if (counter % 3 == 0) {
                writer.write(a);
                writer.write('\n');
            }
            counter++;
        }
        writer.close();
    }
}
