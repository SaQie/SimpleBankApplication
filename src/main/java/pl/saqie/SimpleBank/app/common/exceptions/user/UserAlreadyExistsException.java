package pl.saqie.SimpleBank.app.common.exceptions.user;

public class UserAlreadyExistsException extends Exception{

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
