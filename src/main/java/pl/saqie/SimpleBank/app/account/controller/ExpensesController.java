package pl.saqie.SimpleBank.app.account.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.saqie.SimpleBank.app.transaction.model.dto.ExpenseDto;
import pl.saqie.SimpleBank.app.transaction.service.ExpensesService;
import pl.saqie.SimpleBank.app.user.model.User;

@Controller
@AllArgsConstructor
public class ExpensesController {

    private final ExpensesService service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/expenses")
    public String getExpensesHistory(@RequestParam(required = false, name = "page", defaultValue = "1") int page, Model model, @AuthenticationPrincipal User user){
            Page<ExpenseDto> allExpenses = service.findAllExpenses(user, page);
            model.addAttribute("expenses", allExpenses.getContent());
            model.addAttribute("totalPages", allExpenses.getTotalPages());
            model.addAttribute("currentPage", page);
        return "expenses";
    }
}
