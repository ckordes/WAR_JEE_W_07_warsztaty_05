package pl.coderslab.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BookService {

    public void setBookList(List<Book> bookList) ;

    public List<Book> getBookList() ;

    public Book getBookById(long id) ;

    public void removeBookById(long id) ;

    public void updateBookById(long id, Book book) ;

    public void addBookToList(Book book) ;
}
