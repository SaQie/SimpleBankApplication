package pl.saqie.SimpleBank.app.component.transaction.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.AccountNotFoundException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.InvalidValueException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.SameAccountException;
import pl.saqie.SimpleBank.app.component.transaction.usecase.transfermoney.TransferMoneyDto;
import pl.saqie.SimpleBank.app.component.transaction.usecase.transfermoney.TransferMoneyUseCase;
import pl.saqie.SimpleBank.app.component.user.User;

import javax.validation.Valid;
import java.text.ParseException;

@Controller
@AllArgsConstructor
public class TransferController {

    private final TransferMoneyUseCase transferService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/transfer")
    public String getTransferPage(Model model){
        model.addAttribute(new TransferMoneyDto());
        return "transfer";
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/transfer")
    public String getTransferPageFromRecipient(@ModelAttribute TransferMoneyDto transferMoneyDto, Model model){
        model.addAttribute(transferMoneyDto);
        return "transfer";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/transfer")
    public String processTransferForm(@ModelAttribute @Valid TransferMoneyDto transferDto, BindingResult bindingResult, @AuthenticationPrincipal User user, Model model) {
        if (!bindingResult.hasErrors()){
            try {
                transferService.transfer(user, transferDto);
                model.addAttribute("transferSuccess", "Pomyślnie wykonano przelew, odbiorca otrzymał środki na konto.");
            } catch (AccountNotFoundException | NotEnoughMoneyException | ParseException | SameAccountException | InvalidValueException e) {
                model.addAttribute("error", e.getMessage());
            }
        }
        return "transfer";
    }

}
