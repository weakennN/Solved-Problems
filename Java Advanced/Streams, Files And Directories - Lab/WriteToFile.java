package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {

    public static void main(String[] args) {

        String toRemove = ",.!?";
        try (FileInputStream fileInputStream = new FileInputStream("D:\\Files-and-Streams\\input.txt")) {
            Scanner scan = new Scanner(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Files-and-Streams\\text.txt");
            while (scan.hasNext()) {
                String word = scan.nextLine();

                for (int i = 0; i < word.length(); i++) {
                    char symbol = word.charAt(i);
                    if (!toRemove.contains(symbol + "")){
                        fileOutputStream.write(symbol);
                    }
                }

                fileOutputStream.write('\n');
            }

            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException a) {

        }


    }
}
