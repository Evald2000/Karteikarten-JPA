package academy.mischok.Karteikarten.lernen;


import academy.mischok.Karteikarten.controller.repository.StapelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LernenMenuController {
    @Autowired
    private StapelRepository stapelRepo;




    @GetMapping("/lernenMenu")
    public String lernen(String name, Model model) {

        model.addAttribute("stapelList", stapelRepo.findAll());


        return "lernenMenu";
    }


    @GetMapping(value = "/text")
    public String text(@ModelAttribute String text) {
        text = "lololo";
        return "lernen";
    }
}

