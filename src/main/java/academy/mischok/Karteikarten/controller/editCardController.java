package academy.mischok.Karteikarten.controller;

import academy.mischok.Karteikarten.card.Card;
import academy.mischok.Karteikarten.Methods;

import academy.mischok.Karteikarten.controller.repository.AntwortRepository;
import academy.mischok.Karteikarten.controller.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class editCardController {


    @Autowired
    private CardRepository cardRepo;

    @Autowired
    private AntwortRepository antwortRepo;
    @Autowired
    private Methods methods;

    private int count = 0;
    private int quiz_id = 1;
    private String altQ = "";

    private String altA = "";
    private Integer idc = 0;

    @GetMapping("/editCard/{id}")
    public String editCard(@PathVariable Integer id, Model model) {
        idc = id;
        model.addAttribute("NewCardObject", new Card());
        model.addAttribute("card", cardRepo.findCardById(id));
        altQ = cardRepo.findCardById(id).getQuestion();
        altA = cardRepo.findCardById(id).getAnswer();
        return "editCard";

    }

    @PostMapping("/editCard/")
    public String cardUpdate(@ModelAttribute Card card, Model model) throws Exception {

        model.addAttribute("NewCardObject", new Card());
        if (card.getQuestion() != null) {
            cardRepo.updateCardQuestionById(Long.valueOf(idc), card.getQuestion());
        } else {
            cardRepo.updateCardQuestionById(Long.valueOf(idc),altA);
        }
        if (card.getAnswer() != null) {
            cardRepo.updateCardAnswerById(Long.valueOf(idc), card.getAnswer());
        } else {
            cardRepo.updateCardAnswerById(Long.valueOf(idc), altA);
        }
        return "redirect:/stapelView?id=" + card.getStapel_id();
    }

}
