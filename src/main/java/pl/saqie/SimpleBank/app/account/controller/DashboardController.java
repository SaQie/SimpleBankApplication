package pl.saqie.SimpleBank.app.account.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.SimpleBank.app.account.model.dto.DashboardDto;
import pl.saqie.SimpleBank.app.account.service.DashboardService;
import pl.saqie.SimpleBank.app.user.model.User;

@Controller
@AllArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

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
