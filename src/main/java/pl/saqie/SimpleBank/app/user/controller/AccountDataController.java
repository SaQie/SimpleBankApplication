package pl.saqie.SimpleBank.app.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user.model.dto.AccountDataDto;
import pl.saqie.SimpleBank.app.user.service.AccountDataService;

@Controller
@AllArgsConstructor
public class AccountDataController {

    private final AccountDataService service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/details")
    public String getAccountDataPage(@AuthenticationPrincipal User user, Model model){
        AccountDataDto accountData = service.getAccountData(user.getId());
        model.addAttribute("data", accountData);
        return "account_data";
    }
}
