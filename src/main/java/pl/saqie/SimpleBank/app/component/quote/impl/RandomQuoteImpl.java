package pl.saqie.SimpleBank.app.component.quote.impl;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.component.quote.RandomQuote;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RandomQuoteImpl implements RandomQuote {

    private static final List<String> quotations = Arrays.asList("Nie mów mi, jakie są twoje priorytety. Pokaż mi, na co wydajesz pieniądze, a sam ci powiem, gdzie one są. - JAMES W. FRICK",
            "Zrobić budżet to wskazać swoim pieniądzom, dokąd mają iść, zamiast się zastanawiać, gdzie się rozeszły. - JOHN C.MAXWELL",
            "Do sukcesu nie ma żadnej windy. Trzeba iść po schodach. -EMIL OESCH",
            "Nawyk zarządzania pieniędzmi jest ważniejszy niż ilość posiadanych pieniędzy. -T.HARV EKER",
            "Nigdy nie polegaj na pojedynczym dochodzie. Inwestuj w siebie z zamiarem stworzenia drugiego źródła, potem trzeciego, potem czwartego. - WARREN BUFFETT",
            "Zasada nr 1: Nigdy nie trać pieniędzy. Zasada nr 2: Zawsze pamiętaj o zasadzie nr 1. -WARREN BUFFETT",
            "Jest tylko jeden sposób, który pozwoli ci utrzymać bogactwo: wydawaj mniej, niż zarabiasz, a różnicę inwestuj. -AYN RAND",
            "Lepiej jest godzinę pomyśleć o swoich pieniądzach, niż tydzień na nie pracować. -ANDRE KOSTOLANY",
            "Uważaj na małe wydatki. Niewielki wyciek zatopi wielki statek. -BENJAMIN FRANKLIN");

    private static final Random random = new Random();

    @Override
    public String generateRandomQuote() {
        return quotations.get(random.nextInt(quotations.size()));
    }
}
