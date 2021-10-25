package JavaFundamentals.ArraysLab;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String line = scan.nextLine();
            String [] input = line.split(" ");

            for(int i = 0;i < input.length / 2;i++){

                String c = input[i];
                input[i] = input[input.length - i - 1];
                input[input.length - i - 1] = c;

            }
        System.out.println(String.join(" ",input));
    }
}
