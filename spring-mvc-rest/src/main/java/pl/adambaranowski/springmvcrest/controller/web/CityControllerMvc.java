package pl.adambaranowski.springmvcrest.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.adambaranowski.springmvcrest.model.City;
import pl.adambaranowski.springmvcrest.repository.CityRepository;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityControllerMvc {

    private CityRepository cityRepository;

    @Autowired
    public CityControllerMvc(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public String listCities(Model model){
        List<City> cities = cityRepository.findAll();
        model.addAttribute("cityList", cities);
        return "list";
    }

    //Po redirectcie jest wysyłane nowe zap[ytanie z przeglądarki
    //i są tracone atrybuty modelu ustawionego do rządania
    //RedirectAttributes i addFlashAttributes zapisuje atrybut na
    //chwile w sesji
    @PostMapping
    public String addCity(@ModelAttribute City city, RedirectAttributes redirectAttributes){
        cityRepository.save(city);
        redirectAttributes.addFlashAttribute("message", "City added succesfully");
        return "redirect:/";
    }

}
