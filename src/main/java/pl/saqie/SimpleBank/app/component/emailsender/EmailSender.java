package pl.saqie.SimpleBank.app.component.emailsender;

import javax.mail.MessagingException;

public interface EmailSender {

    void sendRegisterEmail(String to, String token) throws MessagingException;

    void sendForgotPasswordEmail(String to, String token);

}
