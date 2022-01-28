package pl.saqie.SimpleBank.app.component.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.user.usecase.changepassword.ChangePasswordDto;
import pl.saqie.SimpleBank.app.component.user.usecase.changepassword.ChangePasswordUseCase;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class ChangePasswordController {

    private final ChangePasswordUseCase service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/change_password")
    public String getChangePasswordPage(Model model){
        model.addAttribute(new ChangePasswordDto());
        return "password_change";
    }


    @PreAuthorize("isAuthenticated()")
    @PostMapping("/change_password")
    public String processChangePassword(@ModelAttribute @Valid ChangePasswordDto dto, BindingResult bindingResult, @AuthenticationPrincipal User user, Model model){
        if (!bindingResult.hasErrors()) {
            try {
                service.changePassword(dto, user);
                return "redirect:/logout";
            } catch (UserIncompatibilePasswordsException e) {
                model.addAttribute("error", e.getMessage());
            }
        }
        return "password_change";
    }

}
