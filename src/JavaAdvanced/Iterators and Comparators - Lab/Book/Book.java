package IteratorsAndComparators.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {

        setTitle(title);
        setYear(year);
        setAuthors(authors);

    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {

        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", authors=" + authors +
                '}';
    }

    @Override
    public int compareTo(Book other) {

        if (this.title.compareTo(other.title) > 0) {
            return 1;
        } else if (this.title.compareTo(other.title) < 0) {

            return -1;
        }
        return Integer.compare(this.year, other.year);
       /* int compare = this.title.compareTo(other.title);

        if (compare == 0) {
            compare = Integer.compare(this.year, other.year);
        }

        return compare;

        */
    }
}
