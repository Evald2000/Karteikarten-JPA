package academy.mischok.Karteikarten.controller;

import academy.mischok.Karteikarten.Stapel;
import academy.mischok.Karteikarten.card.Card;
import academy.mischok.Karteikarten.Methods;
import academy.mischok.Karteikarten.cardUserAntwort;
import academy.mischok.Karteikarten.controller.repository.AntwortRepository;
import academy.mischok.Karteikarten.controller.repository.CardRepository;
import academy.mischok.Karteikarten.controller.repository.StapelRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuizGameController {


    @Autowired
    private CardRepository cardRepo;
    @Autowired
    private StapelRepository stapelRepo;

    @Autowired
    private AntwortRepository antwortRepo;
    @Autowired
    private Methods methods;

    private int count = 0;
    private int quiz_id = 0;
    private List<Long> currentID;
    private List<String> currentTag;
    private int currentZahl;
    private String currentUser;
    private String color;
    private int idQ;





    @GetMapping("/quizGame")
    public String quizGame(Model model,
                           @RequestParam(required = false) List<Long> stapelId,
                           @RequestParam(required = false) List<String> tag,
                           @RequestParam(required = false) Integer zahl) {

        if (color == null) {
            color = "#002a5c";
        }
        System.out.println("TAGS LISTE"+tag);


        model.addAttribute("color", color);

        if (stapelId == null) {
            stapelId = stapelRepo.findAll().stream().map(Stapel::getId).toList();
        }
        if (tag == null) {
            tag = cardRepo.findAllTags();
        }
        if (zahl == null) {
            zahl = 10;
        }

        if (currentID != null && currentTag != null && currentZahl != 0 && currentUser != null) {
            if (!currentID.equals(stapelId) || !currentTag.equals(tag) || currentZahl != zahl ) {
                count = 0;

            }
        }
        currentID = stapelId;
        currentTag = tag;
        currentZahl = zahl;
        List<Card> cardList=null;


        cardList=getCardList(tag,stapelId);
        System.out.println(cardList);

        if (cardList == null || cardList.size() < zahl) {
            return "redirect:/quizMenuNew";
        }
        model.addAttribute("URL", methods.getCurrentURL().getRequestURL() + "?" + methods.getCurrentURL().getQueryString());
        // TODO: 04.10.23 Counter Fixen
        int points = 0;
        if (count < zahl) {
            if (count == 0) {
                quiz_id++;
            }

            model.addAttribute("count", count++);
            model.addAttribute("quiz", quiz_id);
            model.addAttribute("cardList", methods.getRandomCard(cardList, count, zahl, quiz_id));
            model.addAttribute("formObject", new cardUserAntwort());
            return "quizGame";
        } else {
            count = 0;
            List<cardUserAntwort> antwortList = antwortRepo.findAllByQuizId(quiz_id);
            points = methods.berechneErgebnis(antwortList, cardList);
            model.addAttribute("points", points);
            model.addAttribute("gesamt", zahl);

            model.addAttribute("cardListQuiz", methods.cardAusQuiz(antwortList, cardList));
            model.addAttribute("antwort", antwortList);
            model.addAttribute("trueOderFalse", methods.listeFalseOderTrue(antwortList, cardList));

            return "quizResult";

        }
    }

    @PostMapping("/postquizGame")
    public String questionResult(cardUserAntwort cardUserAntwort, Model model) {

        // TODO: 26.09.23 speichern in datenbank
        antwortRepo.save(cardUserAntwort);

        return "redirect:%s".formatted(cardUserAntwort.getUrl());

    }

    @GetMapping("/About")
    public String about() {

        return "About";
    }

    @GetMapping("/Contact")
    public String contact() {

        return "Contact";
    }

    @RequestMapping(value = "setColor", method = RequestMethod.POST)
    public String setColor(@RequestParam String colorPost) {
        color = colorPost;
        return "LoginHome";
    }

    @RequestMapping(value = "quizResultDetails", method = RequestMethod.POST)
    public String quizResultDetails(@RequestParam Integer id, Model model) {
        idQ = id;
        List<cardUserAntwort> cardUserAntwortList = antwortRepo.findAllByQuizId(idQ);
        List<Card> cardList = cardRepo.findAll();
        List<Card> cardListAusQuiz = methods.cardAusQuiz(cardUserAntwortList, cardList);
        model.addAttribute("antwort", cardUserAntwortList);
        model.addAttribute("cardListQuiz", cardListAusQuiz);
        model.addAttribute("trueOderFalse", methods.listeFalseOderTrue(cardUserAntwortList, cardList));
        model.addAttribute("points", methods.berechneErgebnis(cardUserAntwortList, cardList));
        model.addAttribute("gesamt", cardListAusQuiz.size());
        return "quizResult";

    }

    private List<Card> getCardList(List<String> tag, List<Long> id){

        return cardRepo.findAll((root, query, builder) -> {
            Predicate isAnswer1 = root.get("tags").in(tag);
            Predicate isAnswer2 = root.get("stapelId").in(id);
            return builder.and(isAnswer1, isAnswer2);
    });

    }
}
