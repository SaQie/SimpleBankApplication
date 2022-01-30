package pl.saqie.SimpleBank.app.component.emailsender;

import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.common.emailmessages.RegisterEmailTextMessage;
import pl.saqie.SimpleBank.app.config.application.ApplicationAdressConfig;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailSenderImpl implements EmailSender{

    private final JavaMailSender mailSender;
    private final ApplicationAdressConfig config;

    @Override
    @Async
    public void sendRegisterEmail(String to, String token) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setTo(to);
        messageHelper.setSubject("Rejestracja nowego użytkownika");
        messageHelper.setText(RegisterEmailTextMessage.getRegisterEmailText(config.getApplicationAdress() + "confirm_email?token=" + token),true);
        mailSender.send(mimeMessage);
    }
}
