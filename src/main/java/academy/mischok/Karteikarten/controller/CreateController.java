package academy.mischok.Karteikarten.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateController   {


    @GetMapping("/create")
    public String LoginHome( Model model){


        return "create";
    }
}

