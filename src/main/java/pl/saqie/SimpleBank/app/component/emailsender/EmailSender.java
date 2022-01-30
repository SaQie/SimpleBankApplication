package pl.saqie.SimpleBank.app.component.emailsender;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailSender {

    void sendRegisterEmail(String to, String token) throws MessagingException, UnsupportedEncodingException;

}
