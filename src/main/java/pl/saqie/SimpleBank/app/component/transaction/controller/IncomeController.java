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
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.income.SingleIncomeDto;
import pl.saqie.SimpleBank.app.component.transaction.usecase.allincomes.AllIncomesUseCase;
import pl.saqie.SimpleBank.app.component.transaction.usecase.allincomes.IncomesDto;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.SingleTransactionUseCase;
import pl.saqie.SimpleBank.app.component.user.User;

@Controller
@AllArgsConstructor
public class IncomeController {

    private final AllIncomesUseCase incomeService;
    private final SingleTransactionUseCase singleTransactionService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/incomes")
    public String getIncomesPage(@RequestParam(required = false, name = "page", defaultValue = "1") int page, Model model, @AuthenticationPrincipal User user){
        Page<IncomesDto> allIncomes = incomeService.findAllIncomes(user, page);
        model.addAttribute("incomes", allIncomes.getContent());
        model.addAttribute("totalPages", allIncomes.getTotalPages());
        model.addAttribute("totalElements", allIncomes.getTotalElements());
        model.addAttribute("currentPage", page);
        return "incomes";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/income/{id}")
    public String getSingleIncome(@PathVariable Long id, Model model, @AuthenticationPrincipal User user){
        try {
            SingleIncomeDto singleIncomeById = singleTransactionService.getSingleIncomeById(id, user);
            model.addAttribute("income", singleIncomeById);
        } catch (TransactionNotFoundException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "income";
    }
}
