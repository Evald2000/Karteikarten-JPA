package academy.mischok.Karteikarten.controller;

import academy.mischok.Karteikarten.card.Card;
import academy.mischok.Karteikarten.controller.repository.CardRepository;
import academy.mischok.Karteikarten.controller.repository.StapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateCardController {
    @Autowired
    private CardRepository karte;

    @Autowired
    private StapelRepository stapelRepo;

    @GetMapping("/CreateCardMenu") //Browser get from Server sozusagen
    public String CreateCard(Model model)  {
        model.addAttribute("NewCardObject", new Card());
        model.addAttribute("stapelList", stapelRepo.findAll());
        return "CreateCard";
    }
    @PostMapping("/CreateCard") //Browser send to Server sozusagen
    public String cardSubmit(@ModelAttribute Card card, Model model)  {
        karte.save(card);
        model.addAttribute("NewCardObject", new Card());
        model.addAttribute("stapelList", stapelRepo.findAll());
        return "CreateCard";
    }




}
