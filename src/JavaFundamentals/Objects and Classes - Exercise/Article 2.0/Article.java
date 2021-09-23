package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Article {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<ArticlesInfo> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] info = scan.nextLine().split(", ");

            ArticlesInfo article = new ArticlesInfo(info[0], info[1], info[2]);

            articles.add(article);
       /*     if (com[0].equals("Edit")) {
                article.setContent(com[1]);
            } else if (com[0].equals("Rename")) {
                article.rename(com[1]);
            } else if (com[0].equals("ChangeAuthor")) {
                article.setAuthor(com[1]);
            }
        }

        */
        }

        String criteria = scan.nextLine();

        if (criteria.equals("title")) {
            articles.stream().sorted((p1, p2) -> p1.getTitle().compareTo(p2.getTitle()))
                    .forEach(p -> System.out.println(p.getTitle() + " - " + p.getContent() + ": " + p.getAuthor()));
        } else if (criteria.equals("content")) {
            articles.stream().sorted((p1, p2) -> p1.getContent().compareTo(p2.getContent()))
                    .forEach(p -> System.out.println(p.getTitle() + " - " + p.getContent() + ": " + p.getAuthor()));
        } else if (criteria.equals("author")) {
            articles.stream().sorted((p1, p2) -> p1.getAuthor().compareTo(p2.getAuthor()))
                    .forEach(p -> System.out.println(p.getTitle() + " - " + p.getContent() + ": " + p.getAuthor()));
        }


    }
}
