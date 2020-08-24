package pl.adambaranowski.springmvcbootjar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }
    @GetMapping("/user")
    public String index(HttpServletRequest request){
        String username = request.getParameter("username");

        if (username != null){
            System.out.println("Hello " + username);
        }
        Cookie[] cookies = request.getCookies();

        for (Cookie c:cookies
             ) {
            System.out.println(c.getName() + " " + c.getValue());
        }

        return "index";
    }

    @GetMapping("/usernoservlets")
    public String indexNoServlet(
            @RequestParam(
                    name = "name",
                    required = true,
                    defaultValue = "unknown"
    ) String username,
            @RequestParam(defaultValue = "0") int age,
            @RequestHeader("user-agent")
            String userAgent
            ){
        System.out.println("Hello " + username);
        System.out.println(age-1);
        System.out.println(userAgent);
        return "index";
    }

    @RequestMapping("/")
    public String start(){
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam int number1,
                            @RequestParam int number2){

        System.out.println(number1 + number2);

        return "index";
    }
}
