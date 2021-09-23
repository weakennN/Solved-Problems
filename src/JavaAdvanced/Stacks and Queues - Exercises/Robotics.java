package StackAndQueues;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] robots = scan.nextLine().split("[-;]");
        Map<String, Integer> eachRobot = new LinkedHashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < robots.length; i += 2) {
            eachRobot.putIfAbsent(robots[i], Integer.parseInt(robots[i + 1]));
        }
        int[] secretMap = new int[eachRobot.size()];

        String[] time = scan.nextLine().split(":");

        int hours = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);

        long timeToSeconds = hours * 3600L + min * 60L + seconds;

        String product1 = scan.nextLine();
        while (!product1.equals("End")) {
            queue.offer(product1);
            product1 = scan.nextLine();
        }

        while (!queue.isEmpty()) {
            timeToSeconds++;
            String product = queue.poll();
            for (int i = 0; i < secretMap.length; i++) {
                if (secretMap[i] > 0) {
                    --secretMap[i];
                }
            }

            boolean isTrue = false;
            for (int i = 0; i < secretMap.length; i++) {

                if (secretMap[i] == 0) {
                    int count = 0;
                    for (Map.Entry<String, Integer> robot : eachRobot.entrySet()) {

                        if (count == i) {

                            long convertH = timeToSeconds / 3600 % 24;
                            long convertM = timeToSeconds % 3600 / 60;
                            long sec = timeToSeconds % 60;
                            secretMap[i] = robot.getValue();
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.getKey(), product, convertH, convertM, sec);
                            isTrue = true;
                            break;
                        }
                        count++;
                    }

                    break;
                }

            }
            if (!isTrue) {
                queue.offer(product);
            }
        }


    }
}
