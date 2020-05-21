package gr.example.thymeleaf.fragmentsexample.controller;

import gr.example.thymeleaf.fragmentsexample.service.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    TourService  tourService;

    public IndexController(TourService tourService){
        this.tourService = tourService;
    }

    @GetMapping({"/", "/index"})
    public String welcome(Model model) {
        model.addAttribute("header", "Welcome to the HAEC fullstack Explore Greece project");
        model.addAttribute("title", "Welcome!");
        String subHeader = "page created by Sokratis";
        model.addAttribute("subHeader", subHeader);

        model.addAttribute("tours", tourService.getAll());

        return "index";
    }

    @GetMapping("about")
    public String about(){
        return "about";
    }
}
