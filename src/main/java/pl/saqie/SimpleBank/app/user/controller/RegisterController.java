package pl.saqie.SimpleBank.app.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.SimpleBank.app.user.exception.UserAlreadyExistsException;
import pl.saqie.SimpleBank.app.user.exception.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.user.exception.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;
import pl.saqie.SimpleBank.app.user.service.RegisterService;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final RegisterService registerService; // -> To jest interfejs

    @GetMapping("/register")
    public String getRegisterForm(Model model){
        model.addAttribute(new RegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String processRegisterUser(@ModelAttribute RegisterDto registerDto) throws UserAlreadyExistsException, UserIncompatibilePasswordsException, UserFieldValidationFailedException {
        registerService.addNewUser(registerDto);
        return "register";
    }
}
