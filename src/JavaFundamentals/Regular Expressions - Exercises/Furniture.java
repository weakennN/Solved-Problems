package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        List<String> furniture = new ArrayList<>();
        double finalSum = 0;
        Pattern pattern = Pattern.compile(">>(?<furniture>[A-Za-z]+)<<(?<prize>\\d+\\.?\\d+)!(?<quantity>\\d+)\\b");
        while (!text.equals("Purchase")) {
            Matcher match = pattern.matcher(text);
            if (match.find()) {
                furniture.add(match.group("furniture"));
                double prize = Double.parseDouble(match.group("prize"));
                double quantity = Double.parseDouble((match.group("quantity")));

                finalSum += prize * quantity;
            }
            text = scan.nextLine();
        }
        
        System.out.println("Bought furniture:");
        for (int i = 0; i < furniture.size(); i++) {
            System.out.println(furniture.get(i));
        }
        System.out.printf("Total money spend: %.2f", finalSum);
    }
}
