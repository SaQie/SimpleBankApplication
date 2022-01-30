package pl.saqie.SimpleBank.app.component.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.saqie.SimpleBank.app.common.exceptions.user.TokenNotFoundException;
import pl.saqie.SimpleBank.app.component.user.usecase.confirmemail.ConfirmUserEmailUseCase;

@Controller
@AllArgsConstructor
public class ConfirmEmailController {

    private final ConfirmUserEmailUseCase userEmailUseCase;

    @GetMapping("/confirm_email")
    public String processConfirmUserEmail(@RequestParam(name = "token") String token, Model model){
        try {
            userEmailUseCase.confirmEmail(token);
            model.addAttribute("confirmSuccess", "Pomyślnie potwierdzono adres E-mail dla konta, możesz się zalogować.");
        } catch (TokenNotFoundException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "email_confirm";
    }

}
