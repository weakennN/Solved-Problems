package StreamsFilesAndDirectories;

import java.io.*;

public class LineNumbers {

    public static void main(String[] args) {

            try{
                BufferedReader reader = new BufferedReader(new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

                String line = reader.readLine();
                int count = 1;
                while(line != null){

                    writer.write(count + ". " + line + "\n");
                    line = reader.readLine();
                    count++;
                }
                writer.close();
            }catch (IOException ignored){

            }
    }
}
