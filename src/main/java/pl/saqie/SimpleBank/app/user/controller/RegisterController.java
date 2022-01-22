package pl.saqie.SimpleBank.app.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.SimpleBank.app.user.exception.UserAlreadyExistsException;
import pl.saqie.SimpleBank.app.user.exception.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.user.exception.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;
import pl.saqie.SimpleBank.app.user.service.RegisterService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

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
            } catch (UserAlreadyExistsException | UserFieldValidationFailedException | UserIncompatibilePasswordsException e) {
                model.addAttribute("error", e.getMessage());
            }
        }
        return "register";
    }
}
