package pl.saqie.SimpleBank.app.component.transaction.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.TransactionNotFoundException;
import pl.saqie.SimpleBank.app.component.transaction.usecase.allexpenses.ExpensesDto;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.expense.SingleExpenseDto;
import pl.saqie.SimpleBank.app.component.transaction.usecase.allexpenses.AllExpensesUseCase;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.SingleTransactionUseCase;
import pl.saqie.SimpleBank.app.component.user.User;

@Controller
@AllArgsConstructor
public class ExpenseController {

    private final AllExpensesUseCase service;
    private final SingleTransactionUseCase singleExpenseService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/expenses")
    public String getExpensesHistory(@RequestParam(required = false, name = "page", defaultValue = "1") int page, Model model, @AuthenticationPrincipal User user){
            Page<ExpensesDto> allExpenses = service.findAllExpenses(user, page);
            model.addAttribute("expenses", allExpenses.getContent());
            model.addAttribute("totalPages", allExpenses.getTotalPages());
            model.addAttribute("totalElements", allExpenses.getTotalElements());
            model.addAttribute("currentPage", page);
        return "expenses";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/expense/{id}")
    public String getSingleExpense(@PathVariable Long id, Model model, @AuthenticationPrincipal User user){
        try {
            SingleExpenseDto singleExpenseDto = singleExpenseService.getSingleExpenseById(id, user);
            model.addAttribute("expense", singleExpenseDto);
        } catch (TransactionNotFoundException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "expense";
    }
}
