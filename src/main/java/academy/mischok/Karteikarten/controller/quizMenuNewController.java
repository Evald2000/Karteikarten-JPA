package academy.mischok.Karteikarten.controller;

import academy.mischok.Karteikarten.Methods;

import academy.mischok.Karteikarten.controller.repository.AntwortRepository;
import academy.mischok.Karteikarten.controller.repository.CardRepository;
import academy.mischok.Karteikarten.controller.repository.StapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class quizMenuNewController {
    @Autowired
    private CardRepository cardRepo;
    @Autowired
    private StapelRepository stapelRepo;


    @Autowired
    private AntwortRepository antwortRepo;
    @Autowired
    private Methods methods;

    private int count=0;
    @GetMapping("/quizMenuNew")
    public String quizMenu( Model model){
       model.addAttribute("stapelList",stapelRepo.findAll());
       model.addAttribute("tagList",cardRepo.findAllTags());
        List<Integer> zahlList=new ArrayList<>();
        zahlList.add(5);
        zahlList.add(10);
        zahlList.add(15);
        zahlList.add(20);
        model.addAttribute("zahlList",zahlList);
        model.addAttribute("count",count);
        return "quizMenuNew";
    }


}
