package pl.adambaranowski.springmvcrest.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.adambaranowski.springmvcrest.model.City;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("cityModel", new City());
        return "index";
    }
}
