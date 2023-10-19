package academy.mischok.Karteikarten.controller;


import academy.mischok.Karteikarten.Stapel;
import academy.mischok.Karteikarten.card.Card;
import academy.mischok.Karteikarten.controller.repository.CardRepository;
import academy.mischok.Karteikarten.controller.repository.StapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class LoginHomeController {

    @Autowired
    private StapelRepository stapelRepo;

    @Autowired
    private CardRepository cardRepo;

    @GetMapping("/")
    public String LoginHome(String name, Model model){

        long id=1;
        long id2=2;
        stapelRepo.save(Stapel.builder().id(id).name("English").build());
        stapelRepo.save(Stapel.builder().id(id2).name("Japanisch").build());
        cardRepo.save(Card.builder().stapelId(id).question("Apple").answer("Apfel").tags("Früchte").build());
        cardRepo.save(Card.builder().stapelId(id).question("Banana").answer("Banane").tags("Früchte").build());
        cardRepo.save(Card.builder().stapelId(id).question("Orange").answer("Orange").tags("Früchte").build());
        cardRepo.save(Card.builder().stapelId(id).question("Car").answer("Auto").tags("Fahrzeuge").build());
        cardRepo.save(Card.builder().stapelId(id).question("Bicycle").answer("Fahrrad").tags("Fahrzeuge").build());
        cardRepo.save(Card.builder().stapelId(id).question("Book").answer("Buch").tags("Bücher").build());
        cardRepo.save(Card.builder().stapelId(id).question("Newspaper").answer("Zeitung").tags("Bücher").build());
        cardRepo.save(Card.builder().stapelId(id).question("Table").answer("Tisch").tags("Möbel").build());
        cardRepo.save(Card.builder().stapelId(id).question("Chair").answer("Stuhl").tags("Möbel").build());
        cardRepo.save(Card.builder().stapelId(id).question("Dog").answer("Hund").tags("Tiere").build());
        cardRepo.save(Card.builder().stapelId(id).question("Cat").answer("Katze").tags("Tiere").build());
        cardRepo.save(Card.builder().stapelId(id).question("Elephant").answer("Elefant").tags("Tiere").build());
        cardRepo.save(Card.builder().stapelId(id).question("House").answer("Haus").tags("Gebäude").build());
        cardRepo.save(Card.builder().stapelId(id).question("Apartment").answer("Wohnung").tags("Gebäude").build());
        cardRepo.save(Card.builder().stapelId(id).question("Friend").answer("Freund").tags("Menschen").build());
        cardRepo.save(Card.builder().stapelId(id).question("Family").answer("Familie").tags("Menschen").build());
        cardRepo.save(Card.builder().stapelId(id).question("Computer").answer("Computer").tags("Technologie").build());
        cardRepo.save(Card.builder().stapelId(id).question("Phone").answer("Handy").tags("Technologie").build());
        cardRepo.save(Card.builder().stapelId(id).question("City").answer("Stadt").tags("Orte").build());
        cardRepo.save(Card.builder().stapelId(id).question("Village").answer("Dorf").tags("Orte").build());
        cardRepo.save(Card.builder().stapelId(id).question("Guitar").answer("Gitarre").tags("Musikinstrumente").build());
        cardRepo.save(Card.builder().stapelId(id).question("Piano").answer("Klavier").tags("Musikinstrumente").build());
        cardRepo.save(Card.builder().stapelId(id).question("Train").answer("Zug").tags("Transportmittel").build());
        cardRepo.save(Card.builder().stapelId(id).question("Bicycle").answer("Fahrrad").tags("Transportmittel").build());
        cardRepo.save(Card.builder().stapelId(id).question("Pen").answer("Stift").tags("Schreibwaren").build());
        cardRepo.save(Card.builder().stapelId(id).question("Paper").answer("Papier").tags("Schreibwaren").build());
        cardRepo.save(Card.builder().stapelId(id).question("Sun").answer("Sonne").tags("Himmel").build());
        cardRepo.save(Card.builder().stapelId(id).question("Moon").answer("Mond").tags("Himmel").build());
        cardRepo.save(Card.builder().stapelId(id).question("Rain").answer("Regen").tags("Wetter").build());
        cardRepo.save(Card.builder().stapelId(id).question("Snow").answer("Schnee").tags("Wetter").build());
        cardRepo.save(Card.builder().stapelId(id).question("Food").answer("Essen").tags("Lebensmittel").build());
        cardRepo.save(Card.builder().stapelId(id).question("Drink").answer("Getränk").tags("Lebensmittel").build());
        cardRepo.save(Card.builder().stapelId(id).question("Shirt").answer("Hemd").tags("Kleidung").build());
        cardRepo.save(Card.builder().stapelId(id).question("Shoes").answer("Schuhe").tags("Kleidung").build());

        cardRepo.save(Card.builder().stapelId(id2).question("りんご").answer("Apfel").tags("Früchte").build());
        cardRepo.save(Card.builder().stapelId(id2).question("バナナ").answer("Banane").tags("Früchte").build());
        cardRepo.save(Card.builder().stapelId(id2).question("オレンジ").answer("Orange").tags("Früchte").build());
        cardRepo.save(Card.builder().stapelId(id2).question("車").answer("Auto").tags("Fahrzeuge").build());
        cardRepo.save(Card.builder().stapelId(id2).question("自転車").answer("Fahrrad").tags("Fahrzeuge").build());
        cardRepo.save(Card.builder().stapelId(id2).question("本").answer("Buch").tags("Bücher").build());
        cardRepo.save(Card.builder().stapelId(id2).question("新聞").answer("Zeitung").tags("Bücher").build());
        cardRepo.save(Card.builder().stapelId(id2).question("テーブル").answer("Tisch").tags("Möbel").build());
        cardRepo.save(Card.builder().stapelId(id2).question("椅子").answer("Stuhl").tags("Möbel").build());
        cardRepo.save(Card.builder().stapelId(id2).question("犬").answer("Hund").tags("Tiere").build());
        cardRepo.save(Card.builder().stapelId(id2).question("猫").answer("Katze").tags("Tiere").build());
        cardRepo.save(Card.builder().stapelId(id2).question("象").answer("Elefant").tags("Tiere").build());
        cardRepo.save(Card.builder().stapelId(id2).question("家").answer("Haus").tags("Gebäude").build());
        cardRepo.save(Card.builder().stapelId(id2).question("アパート").answer("Wohnung").tags("Gebäude").build());
        cardRepo.save(Card.builder().stapelId(id2).question("友達").answer("Freund").tags("Menschen").build());
        cardRepo.save(Card.builder().stapelId(id2).question("家族").answer("Familie").tags("Menschen").build());
        cardRepo.save(Card.builder().stapelId(id2).question("コンピュータ").answer("Computer").tags("Technologie").build());
        cardRepo.save(Card.builder().stapelId(id2).question("携帯電話").answer("Handy").tags("Technologie").build());
        cardRepo.save(Card.builder().stapelId(id2).question("市").answer("Stadt").tags("Orte").build());
        cardRepo.save(Card.builder().stapelId(id2).question("村").answer("Dorf").tags("Orte").build());
        cardRepo.save(Card.builder().stapelId(id2).question("ギター").answer("Gitarre").tags("Musikinstrumente").build());
        cardRepo.save(Card.builder().stapelId(id2).question("ピアノ").answer("Klavier").tags("Musikinstrumente").build());
        cardRepo.save(Card.builder().stapelId(id2).question("電車").answer("Zug").tags("Transportmittel").build());
        cardRepo.save(Card.builder().stapelId(id2).question("自転車").answer("Fahrrad").tags("Transportmittel").build());
        cardRepo.save(Card.builder().stapelId(id2).question("ペン").answer("Stift").tags("Schreibwaren").build());
        cardRepo.save(Card.builder().stapelId(id2).question("紙").answer("Papier").tags("Schreibwaren").build());
        cardRepo.save(Card.builder().stapelId(id2).question("太陽").answer("Sonne").tags("Himmel").build());
        cardRepo.save(Card.builder().stapelId(id2).question("月").answer("Mond").tags("Himmel").build());
        cardRepo.save(Card.builder().stapelId(id2).question("雨").answer("Regen").tags("Wetter").build());
        cardRepo.save(Card.builder().stapelId(id2).question("雪").answer("Schnee").tags("Wetter").build());
        cardRepo.save(Card.builder().stapelId(id2).question("食べ物").answer("Essen").tags("Lebensmittel").build());
        cardRepo.save(Card.builder().stapelId(id2).question("飲み物").answer("Getränk").tags("Lebensmittel").build());
        cardRepo.save(Card.builder().stapelId(id2).question("シャツ").answer("Hemd").tags("Kleidung").build());
        cardRepo.save(Card.builder().stapelId(id2).question("靴").answer("Schuhe").tags("Kleidung").build());



        return "LoginHome";
    }
}
