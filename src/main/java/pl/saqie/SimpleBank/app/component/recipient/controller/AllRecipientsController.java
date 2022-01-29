package pl.saqie.SimpleBank.app.component.recipient.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.saqie.SimpleBank.app.component.recipient.usecase.allrecipients.AllRecipientsDto;
import pl.saqie.SimpleBank.app.component.recipient.usecase.allrecipients.AllRecipientsUseCase;
import pl.saqie.SimpleBank.app.component.transaction.usecase.transfermoney.TransferMoneyDto;
import pl.saqie.SimpleBank.app.component.user.User;

@Controller
@AllArgsConstructor
public class AllRecipientsController {

    private final AllRecipientsUseCase allRecipientsUseCase;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/recipients")
    public String getAllRecipients(@RequestParam(required = false, name = "page", defaultValue = "1") int page, @AuthenticationPrincipal User user, Model model){
        Page<AllRecipientsDto> allRecipients = allRecipientsUseCase.findAllRecipients(user, page);
        model.addAttribute("recipients", allRecipients.getContent());
        model.addAttribute("totalPages", allRecipients.getTotalPages());
        model.addAttribute("totalElements", allRecipients.getTotalElements());
        model.addAttribute("currentPage", page);
        model.addAttribute(new TransferMoneyDto());
        return "recipients";
    }

}
