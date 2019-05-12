package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;
import pl.coderslab.model.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
//    @Qualifier("memoryBookService") //jesli nie dajemy @primary to wtedy mozna wskazac klase, tylko trzeba pamietac,
            //aby nazwe klasy dac z malej litery
    BookService memoryBookService;

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getBookList() {
        return memoryBookService.getBookList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Book getBookById(@PathVariable long id) {
        return memoryBookService.getBookById(id);
    }

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addBookToList(@RequestBody Book book) {
        System.out.println(book.toString());
        memoryBookService.addBookToList(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateBookInTheList(@RequestBody Book book, @PathVariable long id) {
        memoryBookService.updateBookById(id, book);
        System.out.println("book updated");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBookInTheList(@PathVariable long id) {
        memoryBookService.removeBookById(id);
        System.out.println("book updated");
    }
}