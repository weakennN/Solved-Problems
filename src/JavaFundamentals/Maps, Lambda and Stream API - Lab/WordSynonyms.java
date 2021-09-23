package AssociativeArrays;

import java.util.*;

public class WordSynonyms {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<String>> synonyms = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String word1 = scan.nextLine();
            String word2 = scan.nextLine();

            if (synonyms.containsKey(word1)) {
                List<String> synonym = synonyms.get(word1);
                synonym.add(word2);
                synonyms.put(word1, synonym);
            } else {
                List<String> synonym = new ArrayList<>();
                synonym.add(word2);
                synonyms.put(word1, synonym);
            }
        }

        for (Map.Entry<String, List<String>> a : synonyms.entrySet()) {
            System.out.printf("%s -%s%n", a.getKey(), a.getValue().toString().replaceAll("[\\]\\[]", " "));
        }
    }
}
