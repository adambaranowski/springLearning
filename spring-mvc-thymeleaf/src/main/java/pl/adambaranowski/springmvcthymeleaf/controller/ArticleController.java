package pl.adambaranowski.springmvcthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.adambaranowski.springmvcthymeleaf.model.Article;

@Controller
public class ArticleController {

    @PostMapping("/add")
    public String addArticle(@ModelAttribute Article formArticle, Model model){
        if(checkNotEmpty(formArticle)){
            model.addAttribute("formArticle", formArticle);
            return "success";
        }else {
            return "redirect:sorry";
        }
    }

    @GetMapping("/sorry")
    public String error(){
        return "errorMessage";
    }

//    @GetMapping("/success")
//    public String success(){
//        return "success";
//    }

    private boolean checkNotEmpty(Article article){
        return (article.getTitle()!=null && article.getTitle().length()>0)
                && (article.getContent()!=null && article.getContent().length()>0);
    }
}