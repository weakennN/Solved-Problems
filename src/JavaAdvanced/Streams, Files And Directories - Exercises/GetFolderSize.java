package StreamsFilesAndDirectories;

import java.io.File;

public class GetFolderSize {

    public static void main(String[] args) {

        String path = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File file = new File(path);

        long sum = 0;

        for (File files : file.listFiles()) {
            sum += files.length();
        }
        System.out.println("Folder size: " + sum);
    }
}
