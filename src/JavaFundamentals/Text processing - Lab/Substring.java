package TextProcessing;

import java.util.Scanner;

public class Substring {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String toRemove = scan.nextLine();
        String mainString = scan.nextLine();

        while (mainString.contains(toRemove)) {

            //ice
            //kicegiciceeb
            String result = mainString.substring(0, mainString.indexOf(toRemove))
                    + mainString.substring(mainString.indexOf(toRemove) + toRemove.length());

            mainString = result;
        }
        System.out.println(mainString);
    }
}
