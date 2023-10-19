package academy.mischok.Karteikarten.controller;



import academy.mischok.Karteikarten.controller.repository.StapelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizMenuController {
    @Autowired
    private StapelRepository stapelRepo;






    @GetMapping("/quizMenu")
    public String quiz(String name, Model model) {
        model.addAttribute("stapelList", stapelRepo.findAll());
        return "quizMenuNew";
    }

    @GetMapping("/custom")
    public String custom() {
        return "Custom";
    }

}

