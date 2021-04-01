package StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {

    public static void main(String[] args) {

        File file = new File("D:\\Files-and-Streams\\Files-and-Streams");

        Deque<File> deque = new ArrayDeque<>();
        int counter = 0;
        deque.add(file);

        while (!deque.isEmpty()) {

            File innerFile = deque.poll();
            counter++;
            System.out.println(innerFile.getName());
            File[] fil = innerFile.listFiles();
            for (File file1 : fil) {

                if (file1.isDirectory()) {
                    deque.add(file1);
                }

            }

        }

        System.out.println(counter + " folders");
    }
}
