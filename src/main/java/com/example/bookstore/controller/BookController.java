package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", repo.findAll());
        return "books/list";
    }

    @GetMapping("/add")
    public String addForm(Book book) {
        return "books/form";
    }

    @PostMapping("/add")
    public String add(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/form";
        }
        repo.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Book book = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "books/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/form";
        }
        book.setId(id);
        repo.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/books";
    }
}
