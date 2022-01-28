package pl.saqie.SimpleBank.app.component.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.user.usecase.accountdata.AccountDataDto;
import pl.saqie.SimpleBank.app.component.user.usecase.accountdata.AccountDataUseCase;

@Controller
@AllArgsConstructor
public class AccountDataController {

    private final AccountDataUseCase service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/details")
    public String getAccountDataPage(@AuthenticationPrincipal User user, Model model){
        AccountDataDto accountData = service.getAccountData(user.getId());
        model.addAttribute("data", accountData);
        return "account_data";
    }
}
