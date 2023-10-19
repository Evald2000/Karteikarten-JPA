package academy.mischok.Karteikarten.controller;


import academy.mischok.Karteikarten.controller.repository.CardRepository;


import academy.mischok.Karteikarten.controller.repository.StapelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StapelViewController {
    @Autowired
    private StapelRepository stapelRepo;
    @Autowired
    private CardRepository cardRepo;
    private int idc = 0;



    @GetMapping("/stapelView")
    public String quiz(@RequestParam(required = false) Integer id, Model model) {
        idc = id;
        model.addAttribute("cardlist", cardRepo.findAllCardsByStapelId(id));
        model.addAttribute("stapel_id", id);
        return "stapelView";
    }

    @PostMapping("/deleteCard/{id}")
    public String deleteCard(@PathVariable Integer id) {
        cardRepo.deleteById(id);
        return "redirect:/stapelView?id=" + idc;
    }

    @PostMapping("/deleteStapel/{id}")
    public String deleteStapel(@PathVariable Long id) {
        stapelRepo.deleteById(Math.toIntExact(id));
        return "redirect:/edit";
    }

    @PostMapping("/editCard/{id}")
    public String editCard(@PathVariable Integer id) {

        return "editCard?id=" + id;
    }

}
