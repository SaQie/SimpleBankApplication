package pl.saqie.SimpleBank.app.account.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.saqie.SimpleBank.app.account.model.dto.MyAccountDto;
import pl.saqie.SimpleBank.app.account.service.MyAccountService;
import pl.saqie.SimpleBank.app.user.model.User;

@Controller
@AllArgsConstructor
public class MyAccountController {

    private final MyAccountService service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/myaccount")
    public String getAccountPage(@AuthenticationPrincipal User user, Model model){
        MyAccountDto myAccountInformation = service.getMyAccountInformation(user.getId());
        model.addAttribute("information", myAccountInformation);
        return "my_account";
    }

}
