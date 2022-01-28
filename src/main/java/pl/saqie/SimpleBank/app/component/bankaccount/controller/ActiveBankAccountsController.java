package pl.saqie.SimpleBank.app.component.bankaccount.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.saqie.SimpleBank.app.component.bankaccount.usecase.activebanks.ActiveBanksDto;
import pl.saqie.SimpleBank.app.component.bankaccount.usecase.activebanks.ActiveBanksUseCase;
import pl.saqie.SimpleBank.app.component.user.User;

@Controller
@AllArgsConstructor
public class ActiveBankAccountsController {

    private final ActiveBanksUseCase service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/banks")
    public String getActiveBankAccount(@AuthenticationPrincipal User user, Model model){
        ActiveBanksDto activeBanksByUserId = service.getActiveBanksByUserId(user.getId());
        model.addAttribute("banks", activeBanksByUserId);
        return "banks";
    }

}
