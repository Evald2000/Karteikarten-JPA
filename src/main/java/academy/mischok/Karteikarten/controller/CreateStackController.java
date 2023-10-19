package academy.mischok.Karteikarten.controller;

import academy.mischok.Karteikarten.Stapel;
import academy.mischok.Karteikarten.controller.repository.StapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateStackController {

    @Autowired
    private StapelRepository stapel;


    @GetMapping("/CreateStack")
    public String get(String name, Model model) throws Exception {
        model.addAttribute("NewStackObject", new Stapel());

        return "CreateStack";
    }

    @PostMapping("/PostStack")
    public String set(@ModelAttribute Stapel stack, Model model) throws Exception {
        stapel.save(stack);
        model.addAttribute("NewStackObject", new Stapel());
        return "CreateStack";
    }
}
