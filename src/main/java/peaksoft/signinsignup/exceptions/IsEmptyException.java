package peaksoft.signinsignup.exceptions;

public class IsEmptyException extends RuntimeException {

    public IsEmptyException() {
    }

    public IsEmptyException(String message) {
        super(message);
    }
}
