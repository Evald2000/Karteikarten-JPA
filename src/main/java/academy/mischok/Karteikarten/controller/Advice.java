package academy.mischok.Karteikarten.controller;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@ControllerAdvice("academy.mischok.Karteikarten.controller")
public class Advice {

    @ModelAttribute
public void addAttributes(Model model){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();
    model.addAttribute("userName",currentPrincipalName);

}
}
