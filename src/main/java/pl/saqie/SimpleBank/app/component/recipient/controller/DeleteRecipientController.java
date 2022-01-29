package pl.saqie.SimpleBank.app.component.recipient.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.saqie.SimpleBank.app.component.recipient.usecase.deleterecipient.DeleteRecipientUseCase;
import pl.saqie.SimpleBank.app.component.user.User;

@Controller
@AllArgsConstructor
public class DeleteRecipientController {

    private final DeleteRecipientUseCase deleteRecipientUseCase;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/recipient/delete/{id}")
    public String deleteRecipient(@PathVariable Long id, @AuthenticationPrincipal User user){
        deleteRecipientUseCase.deleteRecipientById(id,user);
        return "redirect:/recipients";
    }

}
