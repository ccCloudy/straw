package cyl.straw.ap.iuser.ex;

public class IllegalParemeterException extends ServiceException {
    public IllegalParemeterException() {
    }

    public IllegalParemeterException(String message) {
        super(message);
    }

    public IllegalParemeterException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalParemeterException(Throwable cause) {
        super(cause);
    }

    public IllegalParemeterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
