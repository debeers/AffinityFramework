package ApiWorker.exception;

/**
 * Created by artem on 4/13/15.
 */
public class RequiredFieldException extends Exception {

    public RequiredFieldException() {
    }

    public RequiredFieldException(String detailMessage) {
        super(detailMessage);

    }

    public RequiredFieldException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);

    }

    public RequiredFieldException(Throwable throwable) {
        super(throwable);

    }
}
