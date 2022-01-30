package pl.saqie.SimpleBank.app.component.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserAlreadyExistsException;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.user.usecase.register.RegisterDto;
import pl.saqie.SimpleBank.app.component.user.usecase.register.UserRegisterUseCase;

import javax.mail.MessagingException;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final UserRegisterUseCase registerService;

    @GetMapping("/register")
    public String getRegisterForm(@AuthenticationPrincipal User user, Model model){
        if (user == null) {
            model.addAttribute(new RegisterDto());
            return "register";
        }else{
            return "redirect:/dashboard";
        }
    }

    @PostMapping("/register")
    public String processRegisterUser(@ModelAttribute @Valid RegisterDto registerDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            try {
                registerService.registerUser(registerDto);
                model.addAttribute("registerSuccessfull", "Zostałeś pomyślnie zarejestrowany");
            } catch (UserAlreadyExistsException | UserFieldValidationFailedException | UserIncompatibilePasswordsException | MessagingException e) {
                model.addAttribute("error", e.getMessage());
            }
        }
        return "register";
    }
}
