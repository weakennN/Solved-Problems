package IteratorsAndComparators.StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class Comperator1 implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {

        int result = Integer.compare(first.getName().length(), second.getName().length());

        if (result == 0) {
         /*   String firstLetter = first.getName().charAt(0) + "";
            String secondLetter = second.getName().charAt(0) + "";

          */

            String firstName = first.getName().toLowerCase(Locale.ROOT);
            String secondName = second.getName().toLowerCase(Locale.ROOT);
            result = firstName.compareTo(secondName);

        }

        return result;
    }
}
