package pl.saqie.SimpleBank.app.account.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.SimpleBank.app.account.exception.CurrencyNotFoundException;
import pl.saqie.SimpleBank.app.account.model.dto.CurrencyDto;
import pl.saqie.SimpleBank.app.account.service.CurrencyService;
import pl.saqie.SimpleBank.app.infrastructure.currency.Currencies;
import pl.saqie.SimpleBank.app.infrastructure.dto.AllCurrenciesGeneralDto;
import pl.saqie.SimpleBank.app.infrastructure.dto.SingleCurrencyGeneralDto;

@Controller
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyService service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/currencies")
    public String getAllCurrencies(Model model){
        AllCurrenciesGeneralDto[] allCurrenciesGeneralDto = service.getAllCurrencies();
        model.addAttribute("currencies", allCurrenciesGeneralDto);
        return "currencies";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/currency/{code}")
    public String getSingleCurrency(@PathVariable String code, Model model){
        try {
            SingleCurrencyGeneralDto singleCurrency = service.getSingleCurrency(code);
            model.addAttribute("currency", singleCurrency);
        } catch (CurrencyNotFoundException e) {
            model.addAttribute("error",e.getMessage());
        }
        return "selected_currency";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/currency")
    public String getSingleCurrencyList(Model model){
        model.addAttribute("currencies", Currencies.values());
        model.addAttribute(new CurrencyDto());
        return "currency";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/currency")
    public String processSingleCurrency(@ModelAttribute CurrencyDto currencyDto){
        return "redirect:/currency/"+currencyDto.getCode();
    }
}
