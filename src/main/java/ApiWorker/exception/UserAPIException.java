package ApiWorker.exception;

import java.io.IOException;

/**
 * Created by artem on 2/17/16.
 */
public class UserAPIException extends IOException {

    public UserAPIException() {

    }

    public UserAPIException(String detailMessage) {
        super(detailMessage);

    }

    public UserAPIException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);

    }

    public UserAPIException(Throwable throwable) {
        super(throwable);

    }
}
