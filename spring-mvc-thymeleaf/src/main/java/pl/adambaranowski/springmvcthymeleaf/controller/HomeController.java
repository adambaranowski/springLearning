package pl.adambaranowski.springmvcthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.adambaranowski.springmvcthymeleaf.model.Article;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("helloMessage", "Hello Thymeleaf");
        model.addAttribute(
                "formArticle",
                new Article("Przykładowy tytuł","jakiś content", "tag1, tag2")
        );
        return "index";
    }
}
