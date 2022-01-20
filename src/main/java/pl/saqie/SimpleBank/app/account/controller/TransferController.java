package pl.saqie.SimpleBank.app.account.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.SimpleBank.app.account.exception.AccountNotFoundException;
import pl.saqie.SimpleBank.app.account.exception.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.account.exception.SameAccountException;
import pl.saqie.SimpleBank.app.account.model.dto.TransferDto;
import pl.saqie.SimpleBank.app.account.service.TransferService;
import pl.saqie.SimpleBank.app.transaction.model.Transaction;
import pl.saqie.SimpleBank.app.transaction.repository.TransactionRepository;
import pl.saqie.SimpleBank.app.user.model.User;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
@AllArgsConstructor
public class TransferController {

    private final TransferService transferService;
    private final TransactionRepository repository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/transfer")
    public String getTransferPage(Model model){
        model.addAttribute(new TransferDto());
        return "transfer";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/transfer")
    public String processTransferForm(@ModelAttribute @Valid TransferDto transferDto, BindingResult bindingResult, @AuthenticationPrincipal User user, Model model) {
        if (!bindingResult.hasErrors()){
            try {
                transferService.transfer(user, transferDto);
                model.addAttribute("transferSuccess", "Pomyślnie wykonano przelew, odbiorca otrzymał środki na konto.");
            } catch (AccountNotFoundException | NotEnoughMoneyException | ParseException | SameAccountException e) {
                model.addAttribute("error", e.getMessage());
            }
        }
        return "transfer";
    }

}
