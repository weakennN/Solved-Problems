package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PredicateParty {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scan.nextLine();

        BiFunction<List<String>, String, List<String>> doubleTheList;

        while (!command.equals("Party!")) {

            String[] input = command.split("\\s+");

            String com = input[0];
            String secondCom = input[1];
            if (com.equals("Remove")) {

                if (secondCom.equals("StartsWith")) {
                    list.removeIf(str -> str.startsWith(input[2]));
                } else if (secondCom.equals("EndsWith")) {
                    list.removeIf(str -> str.endsWith(input[2]));
                } else if (secondCom.equals("Length")) {
                    int length = Integer.parseInt(input[2]);
                    list.removeIf(str -> str.length() == length);
                }
            } else if (com.equals("Double")) {

                if (secondCom.equals("StartsWith")) {
                    doubleTheList = doubleOfCriteria(secondCom);
                    list = doubleTheList.apply(list, input[2]);
                } else if (secondCom.equals("EndsWith")) {
                    doubleTheList = doubleOfCriteria(secondCom);
                    list = doubleTheList.apply(list, input[2]);
                } else {
                    int length = Integer.parseInt(input[2]);
                    doubleTheList = doubleOfCriteria(secondCom);
                    list = doubleTheList.apply(list, input[2]);
                }

            }

            command = scan.nextLine();
        }

        if (list.size() == 0) {
            System.out.println("Nobody is going to the party!");
            return;
        }
        String str = list.stream().sorted(String::compareTo)
                .collect(Collectors.joining(", "));
        System.out.println(str + " are going to the party!");


    }

    public static BiFunction<List<String>, String, List<String>> doubleOfCriteria(String com) {

        if (com.equals("StartsWith")) {
            return (l, str) -> {
                List<String> result = new ArrayList<>();

                for (int i = 0; i < l.size(); i++) {
                    result.add(l.get(i));
                    if (l.get(i).startsWith(str)) {
                        result.add(l.get(i));
                    }
                }

                return result;
            };
        } else if (com.equals("EndsWith")) {

            return (l, str) -> {
                List<String> result = new ArrayList<>();

                for (int i = 0; i < l.size(); i++) {
                    result.add(l.get(i));
                    if (l.get(i).endsWith(str)) {
                        result.add(l.get(i));
                    }
                }

                return result;
            };
        }

        return (l, str) -> {
            List<String> result = new ArrayList<>();
            int length = Integer.parseInt(str);
            for (int i = 0; i < l.size(); i++) {
                result.add(l.get(i));
                if (l.get(i).length() == length) {
                    result.add(l.get(i));
                }
            }

            return result;
        };
    }


}

