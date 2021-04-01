package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\Files-and-Streams\\ex1.txt");
        Scanner scan = new Scanner(fileInputStream);

        FileWriter writer = new FileWriter("D:\\Files-and-Streams\\text.txt");

        while (scan.hasNext()) {

            if (scan.hasNextInt()) {
                System.out.println(scan.nextInt());
            }

            scan.next();
        }

        writer.flush();
        writer.close();
    }
}
