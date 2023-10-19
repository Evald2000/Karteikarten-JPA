package academy.mischok.Karteikarten.controller;
import academy.mischok.Karteikarten.controller.repository.StapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditController {
    @Autowired
    private StapelRepository stapelRepo;





    @GetMapping("/edit")
    public String quiz(String name, Model model) {
        model.addAttribute("stapelList", stapelRepo.findAll());

        return "edit";
    }
}
