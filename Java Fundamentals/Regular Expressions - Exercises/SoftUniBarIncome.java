package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String com = scan.nextLine();
        Pattern pattern = Pattern.compile("%(?<name>[A-Za-z]+)%[^\\|\\$\\%\\.]*?<(?<product>\\w+)>[^\\|\\$\\%\\.]*?\\|(?<quantity>\\d+)\\|[^\\|\\$\\%\\.]*?(?<prize>\\d+\\.?\\d+)\\$");
        double sum = 0;
        double finalSum = 0;

        while (!com.equals("end of shift")) {

            Matcher match = pattern.matcher(com);

            if (match.find()) {
                double prize = Double.parseDouble((match.group("prize")));
                int quantity = Integer.parseInt(match.group("quantity"));

                sum = prize * quantity;
                finalSum += sum;
                System.out.printf("%s: %s - %.2f%n", match.group("name"), match.group("product"), sum);
            }

            com = scan.nextLine();
        }
        System.out.printf("Total income: %.2f", finalSum);
    }
}
