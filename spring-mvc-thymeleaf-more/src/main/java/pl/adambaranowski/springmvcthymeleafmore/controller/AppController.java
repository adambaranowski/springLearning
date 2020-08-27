package pl.adambaranowski.springmvcthymeleafmore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.adambaranowski.springmvcthymeleafmore.model.Book;

import java.util.Arrays;

@Controller
public class AppController {
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("book", new Book());
        return "home";
    }

    @GetMapping("/if")
    public String ifExample(Model model){
        model.addAttribute("text", "sample text");
        model.addAttribute("a", 123);
        model.addAttribute("b", 456);
        return "if";
    }

    @GetMapping("/loop")
    public String loopExample(Model model){
        model.addAttribute("books", Arrays.asList(
                new Book("Książka 1", "Author 1", 59.99),
                new Book("Książka 2", "author 2", 70.00)
        ));
        return "loop";
    }

    @PostMapping("/bookadd")
    public String bookAdd(@ModelAttribute Book book, Model model){
        model.addAttribute("message", "Book" + book + "added!");
        return "home";
    }
}
