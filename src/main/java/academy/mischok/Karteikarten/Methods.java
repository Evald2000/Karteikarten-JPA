package academy.mischok.Karteikarten;

import academy.mischok.Karteikarten.card.Card;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class Methods {
    int currentId;
    private ArrayList<Integer> nummernlist = new ArrayList<>();

    public Card getRandomCard(List<Card> cardList, int count, int zahl, int quizID) {
        if (currentId != 0) {
            if (currentId != quizID) {
                nummernlist = new ArrayList<>();
            }
        }
        int randomNumber = 0;

        if (count < zahl + 1) {
            while (true) {
                int listeSize = cardList.size();

                Random random = ThreadLocalRandom.current();
                randomNumber = random.nextInt(0, listeSize);


                if (!nummernlist.contains(randomNumber)) {
                    if (nummernlist.size() == zahl + 1) {
                        nummernlist = new ArrayList<>();
                    }
                    nummernlist.add(randomNumber);
                    break;
                }

            }
            return cardList.get(randomNumber);
        }

        return null;
    }

    public int berechneErgebnis(List<cardUserAntwort> antwortList, List<Card> cardList) {
        int points = 0;

        for (cardUserAntwort antwort : antwortList) {
            String antwortKarte = " ";
            for (Card card : cardList) {
                if (antwort.getCard_id() == card.getId()) {
                    antwortKarte = card.getAnswer();
                }
            }
            if (antwort.getUser_antwort().compareToIgnoreCase(antwortKarte) == 0) {
                points++;
            }

        }
        System.out.println(points);
        return points;
    }

    public List<Card> cardAusQuiz(List<cardUserAntwort> antwortList, List<Card> cardList) {
        List<Card> cardAusQuiz = new ArrayList<>();
        for (cardUserAntwort antwort : antwortList) {
            for (Card card : cardList) {
                if (antwort.getCard_id() == card.getId()) {
                    cardAusQuiz.add(card);
                }
            }
        }
        return cardAusQuiz;
    }

    public List<Integer> listeFalseOderTrue(List<cardUserAntwort> antwortList, List<Card> cardList) {
        List<Integer> listeFalseOderTrue = new ArrayList<>();
        for (cardUserAntwort antwort : antwortList) {
            String antwortKarte = "";
            for (Card card : cardList) {
                if (antwort.getCard_id() == card.getId()) {
                    antwortKarte = card.getAnswer();
                }
            }
            if (antwort.getUser_antwort().compareToIgnoreCase(antwortKarte) == 0) {
                listeFalseOderTrue.add(1);
            } else {
                listeFalseOderTrue.add(0);
            }

        }
        return listeFalseOderTrue;
    }

    public HttpServletRequest getCurrentURL() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes) requestAttributes).getRequest();
        } else {
            return null;
        }
    }

    public List<TransverClassResult> quizResults(List<cardUserAntwort> UserAntworts, List<Stapel> stapelList, List<Card> cardList, List<Integer> quizIds) {
        List<TransverClassResult> list = new ArrayList<>();


        TransverClassResult transverClassResult;

        for (Integer i : quizIds) {
            String stapels = "";
            String tags = "";
            int countGesamt = 0;
            int countTrue = 0;
            for (cardUserAntwort j : UserAntworts) {
                if (i == j.getQuiz_id()) {
                    if (!stapels.contains(stapelList.get(j.getStapel_id() - 1).name)) {

                        stapels += stapelList.get(j.getStapel_id() - 1).name + " ";

                    }
                    if (!tags.contains(cardList.get(j.getCard_id() - 1).getTags())) {

                        tags += cardList.get(j.getCard_id() - 1).getTags() + " ";
                    }
                    if (j.getUser_antwort().compareToIgnoreCase(cardList.get(j.getCard_id() - 1).getAnswer()) == 0) {

                        countTrue += 1;
                    }
                    countGesamt++;

                }
            }
            transverClassResult = new TransverClassResult(stapels, tags, countTrue, countGesamt, i);
            list.add(transverClassResult);
        }

        return list;
    }
}
