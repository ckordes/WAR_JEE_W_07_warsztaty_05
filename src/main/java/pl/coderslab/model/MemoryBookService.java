package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MemoryBookService {

    private List<Book> bookList;

    public MemoryBookService() {
        bookList = Arrays.asList(new Book(1L, "1234aaa", "Pierwsza ksiazka", "Jan Kowalski", "Wydawca 1", "sifi"),
                new Book(2L, "1234bbb", "Druga ksiazka", "Grzegorz Brzeczyszczykiewicz", "Wydawca 2", "poezja"),
                new Book(3L, "1234ccc", "Trzecia ksiazka", "Adam Mickiewiecz", "Wydawca 3", "horror"),
                new Book(4L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"),
                new Book(5L, "9788324627738", "Rusz glowa, Java.", "Sierra Kathy, Bates Bert", "Helion", "programming"),
                new Book(6L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


    public List<Book> getBookList() {
        return this.bookList;
    }

    public Book getBookById(long id) {
        return bookList.stream().filter(n -> n.getId() == id).findFirst().orElse(null);
    }

    public void removeBookById(long id) {
        bookList.stream().filter(n -> n.getId() == id).findFirst().ifPresent(n -> bookList.remove(n));
    }

    public void updateBookById(long id, Book book) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                bookList.set(i, book);
                break;
            }
        }
    }

}

/*
Klasa ta powinna posiadać metody:
+Pobieranie listy danych.
+Pobieranie obiektu po wskazanym identyfikatorze.
+Edycje obiektu.
+Usuwanie obiektu.
 */