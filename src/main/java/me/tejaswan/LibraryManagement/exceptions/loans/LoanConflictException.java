package me.tejaswan.LibraryManagement.exceptions.loans;

public class LoanConflictException extends Exception{
    public LoanConflictException() {
    }

    public LoanConflictException(String message) {
        super(message);
    }

    public LoanConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoanConflictException(Throwable cause) {
        super(cause);
    }

    public LoanConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
