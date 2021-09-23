package ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] words = scan.nextLine().split(" ");

        for (int i = 0; i < words.length; i++) {
            Random ran = new Random();

            int a = ran.nextInt(words.length);
            swap(words, i, a);
        }

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }

    public static void swap(String[] arr, int i, int ran) {

        String temp = arr[i];
        arr[i] = arr[ran];
        arr[ran] = temp;
    }

}
