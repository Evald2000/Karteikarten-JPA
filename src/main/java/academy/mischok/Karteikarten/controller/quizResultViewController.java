package academy.mischok.Karteikarten.controller;

import academy.mischok.Karteikarten.*;
import academy.mischok.Karteikarten.controller.repository.AntwortRepository;
import academy.mischok.Karteikarten.controller.repository.CardRepository;

import academy.mischok.Karteikarten.controller.repository.StapelRepository;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


import academy.mischok.Karteikarten.card.Card;
import academy.mischok.Karteikarten.Methods;
import academy.mischok.Karteikarten.cardUserAntwort;

@Controller
public class quizResultViewController {

  @Autowired
   private AntwortRepository antwortRepo;
    @Autowired
    private Methods methods;
    @Autowired
    private StapelRepository stapelRepo;
    @Autowired
    private CardRepository card;

    @GetMapping("/quizResultsView")
    public String quizResult(Model model){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        List<Integer> quizIds=antwortRepo.findAllIdsBYUserName(currentPrincipalName);
        List<Stapel> stapels=stapelRepo.findAll();
        List<Card> cardList=card.findAll();
//        List<cardUserAntwort> antwortList=antwortRepo.findAllByUserName(currentPrincipalName);
//        model.addAttribute("list", methods.quizResults(antwortList,stapels,cardList,quizIds) );
        return "quizResultsView";
    }






}
