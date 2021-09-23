package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("D:\\Files-and-Streams\\input.txt")) {

            int oneByte = fileInputStream.read();
            while (oneByte != -1) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileInputStream.read();
            }
        } catch (IOException a) {

        }
    }
}
