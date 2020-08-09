package lab.comparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(String... authors) {
        this.authors = new ArrayList<>();
        if (authors.length > 0) {
            this.authors.addAll(Arrays.asList(authors));
        }
    }

    @Override
    public int compareTo(Book book) {
        if (this.getTitle().equals(book.getTitle())) {
            return Integer.compare(this.getYear(), book.getYear());
        } else {
            return this.getTitle().compareTo(book.getTitle());
        }
    }

    @Override
    public String toString() {
        return title;
    }
}
