package chetenov.web.exception;

public class NotUniqUsernameException extends RuntimeException {
    public NotUniqUsernameException(String message) {
        super(message);
    }
}
