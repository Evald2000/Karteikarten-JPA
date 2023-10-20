package academy.mischok.Karteikarten.lernen;

import academy.mischok.Karteikarten.card.Card;
import academy.mischok.Karteikarten.SolveAttemptsLearn;

import academy.mischok.Karteikarten.controller.repository.CardRepository;

import academy.mischok.Karteikarten.controller.repository.SolveRepository;
import academy.mischok.Karteikarten.controller.repository.StapelRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class LernenController {
    public int i = 0;
    public int current_id;

    @Autowired
    private CardRepository cardRepo;
    @Autowired
    StapelRepository stapelRepository;
    @Autowired
    SolveRepository solveAttempsRepo;
    Integer maxCounter;
    List<Card> cardList;
    int origListSize;

    int iRepo;

    int bonusCounter = 0;

    Card nextCard;

    @GetMapping("/lernen/{id}")
    public String lernen(@PathVariable("id") int stackId, Model model) {
        Integer maxId=cardRepo.findTopByOrderByIdDesc(stackId);
        Integer minId=cardRepo.findBotByOrderByIdAsc(stackId);
        maxCounter = maxId-minId;
        if (current_id != stackId) { //wenn man in andere Stapel geht
            cardList = cardRepo.findAllCardsByStapelId(stackId);
            i = 1;
            bonusCounter = 0;
        }

        current_id = stackId;
        origListSize = cardList.size();


        List<Card> failedCard = cardRepo.findAllCardsByStapelId(current_id).stream() //Tut Card in liste rein wenn score kleiner als 0 ist
                .filter(c -> getSolveAttemptScore(c.getId()) < 0)
                .toList();
        int currentCardScore = getSolveAttemptScore(cardRepo.findAllCardsByStapelId(current_id).get(i).getId());
        System.out.println("current id:" + cardRepo.findAllCardsByStapelId(current_id).get(i).getId() + "score" + currentCardScore);

        if (bonusCounter == 3 && !failedCard.isEmpty()) { // jeden dritten Zug wenn es eine Karte mit negtiven Score gibt
            // alle SolveAttempts holen
            List<SolveAttemptsLearn> solveAttempts = solveAttempsRepo.findAll().stream() //tut alle Karten die zur jetzige Stapel gehören in eine Liste rein
                    .filter(solveAttempt -> solveAttempt.getStapel_id() == stackId)
                    .toList(); // methode in repo schreiben

            Map<Integer, Integer> cardIdToTotalScoreMap = solveAttempts.stream() // erstellt eine map mit Karten id als key und score als value
                    .collect(Collectors.toMap(
                            SolveAttemptsLearn::getKarte_id,
                            sA -> getSolveAttemptScore(sA.getKarte_id()), //berechnet dem score von der Karte
                            Integer::sum // Handle duplicate keys by summing their scores
                    ));

            List<Map.Entry<Integer, Integer>> sortedEntries = cardIdToTotalScoreMap.entrySet() // Sortiert die Map nach kleinsten score
                    .stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue())
                    .toList();


            Integer cardIdWithLowestScore = sortedEntries.get(0).getKey(); //Karten id mit dem kleinten score


            nextCard = cardRepo.findCardById(cardIdWithLowestScore);

        } else {
            nextCard = cardList.get(i);
        }

        System.out.println("id" + nextCard.getId() + "score" + getSolveAttemptScore(nextCard.getId()));
        model.addAttribute("card", nextCard);

        model.addAttribute("maxID", cardRepo.findAllCardsByStapelId(stackId));
        model.addAttribute("minId", cardRepo.findAllCardsByStapelId(stackId));


        return "lernen";
    }

    private Integer getSolveAttemptScore(Integer cardId) {
        int returnValue = 0;
        for (SolveAttemptsLearn solveAttempt : solveAttempsRepo.findAll().stream().filter(sa -> sa.getKarte_id() == cardId).sorted(Comparator.comparing(SolveAttemptsLearn::getId)).toList()) {
            int summand = (solveAttempt.isFalsch() ? -1 : returnValue == 0 ? 0 : 1);
            returnValue = returnValue + summand;
        }
        return returnValue;

    }

    @GetMapping("/richtig")
    public String richtig() {
        solveAttempsRepo.save(SolveAttemptsLearn.builder()
                .falsch(false)
                .stapelId(current_id)
                .karteId(cardList.get(i).getId())
                .build());
        List<Card> failedCard = cardRepo.findAllCardsByStapelId(current_id).stream()
                .filter(c -> getSolveAttemptScore(c.getId()) < 0)
                .toList();
        if (bonusCounter != 3 || failedCard.isEmpty()) {
            i++;

        } else {
            bonusCounter = -1;
        }

        if (!failedCard.isEmpty()) {
            bonusCounter = Math.min(3, bonusCounter + 1);
        }

        if (i > maxCounter) {
            i = 0;
            return "redirect:lernen/" + current_id;
        }
        return "redirect:lernen/" + current_id;
    }

    @GetMapping("/falsch")
    public String falsch() {
        solveAttempsRepo.save(SolveAttemptsLearn.builder()
                        .falsch(true)
                        .stapelId(current_id)
                        .karteId(cardList.get(i).getId())
                .build());

        List<Card> failedCard = cardRepo.findAllCardsByStapelId(current_id).stream()
                .filter(c -> getSolveAttemptScore(c.getId()) < 0)
                .toList();
        if (bonusCounter != 3 || failedCard.isEmpty()) {
            i++;

        } else {
            bonusCounter = -1;
        }

        if (!failedCard.isEmpty()) {
            bonusCounter = Math.min(3, bonusCounter + 1);
        }
        if (i > maxCounter) {
            i = 0;
            return "redirect:lernen/" + current_id;
        }

        return "redirect:lernen/" + current_id;
    }


}
