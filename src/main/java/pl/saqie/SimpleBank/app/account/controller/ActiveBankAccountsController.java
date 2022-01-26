package pl.saqie.SimpleBank.app.account.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.saqie.SimpleBank.app.account.model.dto.ActiveBanksDto;
import pl.saqie.SimpleBank.app.account.service.ActiveBanksService;
import pl.saqie.SimpleBank.app.user.model.User;

@Controller
@AllArgsConstructor
public class ActiveBankAccountsController {

    private final ActiveBanksService service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/banks")
    public String getActiveBankAccount(@AuthenticationPrincipal User user, Model model){
        ActiveBanksDto activeBanksByUserId = service.getActiveBanksByUserId(user.getId());
        model.addAttribute("banks", activeBanksByUserId);
        return "banks";
    }

}
