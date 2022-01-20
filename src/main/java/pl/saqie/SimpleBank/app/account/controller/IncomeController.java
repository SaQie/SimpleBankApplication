package pl.saqie.SimpleBank.app.account.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.saqie.SimpleBank.app.account.model.dto.IncomeDto;
import pl.saqie.SimpleBank.app.account.service.IncomeService;
import pl.saqie.SimpleBank.app.user.model.User;

@Controller
@AllArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/incomes")
    public String getIncomesPage(@RequestParam(required = false, name = "page", defaultValue = "1") int page, Model model, @AuthenticationPrincipal User user){
        Page<IncomeDto> allIncomes = incomeService.findAllIncomes(user, page);
        model.addAttribute("incomes", allIncomes.getContent());
        model.addAttribute("totalPages", allIncomes.getTotalPages());
        model.addAttribute("currentPage", page);
        return "incomes";
    }

}
