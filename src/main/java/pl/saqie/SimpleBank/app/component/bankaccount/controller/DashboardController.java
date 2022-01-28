package pl.saqie.SimpleBank.app.component.bankaccount.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.SimpleBank.app.component.bankaccount.usecase.dashboard.DashboardDto;
import pl.saqie.SimpleBank.app.component.bankaccount.usecase.dashboard.DashboardUseCase;
import pl.saqie.SimpleBank.app.component.user.User;

@Controller
@AllArgsConstructor
public class DashboardController {

    private final DashboardUseCase dashboardService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/dashboard")
    public String getDashboardPage(@AuthenticationPrincipal User user, Model model){
        DashboardDto informations = dashboardService.getDashboardInformations(user);
        model.addAttribute("dashboardInformations", informations);
        return "dashboard";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/dashboard")
    public String getDashboardPageFromLogin(){
        return "redirect:/dashboard";
    }

}
