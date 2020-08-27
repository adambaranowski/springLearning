package pl.adambaranowski.springmvcscopes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.adambaranowski.springmvcscopes.component.ShoppingCart;

@Controller
public class AddCartController {
    private ShoppingCart shoppingCart;
    @Autowired
    public AddCartController(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }



    @PutMapping("/add")
    public String put(@RequestParam String product){
        System.out.println(product);
        return "index";

    }

    @PostMapping("/add")
    public String addProductPost(@RequestParam(name = "product") String product){
        System.out.println(product);
        shoppingCart.addProduct(product);
        return "redirect:/add";
    }
    @GetMapping("/add")
    public String ok(){
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.DELETE)
    public String addProduct(@RequestParam(name = "product") String product){
        System.out.println(product);
        shoppingCart.addProduct(product);
        return "index";
    }
}
