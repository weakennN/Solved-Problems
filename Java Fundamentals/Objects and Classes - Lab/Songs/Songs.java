package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        SongInfo[] num = new SongInfo[n];

        for (int i = 0; i < n; i++) {

            String[] songs = scan.nextLine().split("_");

            SongInfo song = new SongInfo();

            song.setTypeList(songs[0]);
            song.setName(songs[1]);
            song.setTime(songs[2]);

            num[i] = song;
        }

        String type = scan.nextLine();

        if (type.equals("all")) {

            for (SongInfo song : num) {
                System.out.println(song.getName());
            }
        } else {
            for (SongInfo song : num) {
                if (song.getTypeList().equals(type)) {
                    System.out.println(song.getName());
                }
            }
        }


    }
}
