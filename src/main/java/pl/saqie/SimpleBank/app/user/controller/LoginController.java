package pl.saqie.SimpleBank.app.user.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.saqie.SimpleBank.app.user.model.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(@AuthenticationPrincipal User user){
        if (user == null) {
            return "login";
        }else{
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/")
    public String redirectToLoginPage(){
        return "redirect:/login";
    }
}
