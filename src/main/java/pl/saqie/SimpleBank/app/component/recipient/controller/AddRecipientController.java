package pl.saqie.SimpleBank.app.component.recipient.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.SimpleBank.app.common.exceptions.recipient.RecipientAlreadyExistsException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.AccountNotFoundException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.SameAccountException;
import pl.saqie.SimpleBank.app.component.recipient.usecase.addrecipient.AddRecipientUseCase;
import pl.saqie.SimpleBank.app.component.recipient.usecase.addrecipient.RecipientDto;
import pl.saqie.SimpleBank.app.component.user.User;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class AddRecipientController {

    private final AddRecipientUseCase addRecipientUseCase;


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/recipient/add")
    public String getAddRecipientPage(Model model){
        model.addAttribute(new RecipientDto());
        return "add_recipient";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/recipient/add")
    public String addNewRecipient(@ModelAttribute @Valid RecipientDto recipientDto, BindingResult bindingResult, @AuthenticationPrincipal User user, Model model){
        if (!bindingResult.hasErrors()) {
            try {
                addRecipientUseCase.addNewRecipient(recipientDto, user);
                model.addAttribute("recipientAddSuccess", "Pomyślnie dodano odbiorcę do Twojej listy.");
            } catch (RecipientAlreadyExistsException | AccountNotFoundException | SameAccountException e) {
                model.addAttribute("error", e.getMessage());
            }
        }
        return "add_recipient";
    }

}
