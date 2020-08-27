package pl.adambaranowski.springmvcdispatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.adambaranowski.springmvcdispatch.component.EventHolder;
import pl.adambaranowski.springmvcdispatch.model.Participant;

@Controller
public class EventController {
    private EventHolder eventHolder;

    @Autowired
    public EventController(EventHolder eventHolder) {
        this.eventHolder = eventHolder;
    }

    @PostMapping("/register")
    public String register(@RequestParam String firstName,
    @RequestParam String lastName){
        Participant participant = new Participant(firstName, lastName);
        if(eventHolder.checkRegistration(participant)){
            return "redirect:fail";
        }else{
            eventHolder.addParticipant(participant);
            return "redirect:success";
        }
    }

    @GetMapping("/success")
    public String success(){
        return "success";
}

    @GetMapping("/fail")
    public String error(){
        return "fail";
    }

    @GetMapping("/show")
    public String show(){
        for (Participant p: eventHolder.getParticipants()
             ) {
            System.out.println(p);
        }
        System.out.println("xdddddd");
        return "redirect:/";
    }
}
