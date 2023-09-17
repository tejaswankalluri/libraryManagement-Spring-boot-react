package me.tejaswan.LibraryManagement.exceptions;

import me.tejaswan.LibraryManagement.entities.ErrorHandler;
import me.tejaswan.LibraryManagement.exceptions.common.NotFoundException;
import me.tejaswan.LibraryManagement.exceptions.loans.LoanConflictException;
import me.tejaswan.LibraryManagement.exceptions.loans.LoanNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ResponseEntityErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorHandler> NotFoundException(NotFoundException exception,
                                                              WebRequest request) {
        String path = extractPath(request);
        ErrorHandler message = new ErrorHandler(HttpStatus.NOT_FOUND, exception.getMessage(), false, path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<ErrorHandler> LoanNotFoundException(LoanNotFoundException exception,
                                                              WebRequest request) {
        String path = extractPath(request);
        ErrorHandler message = new ErrorHandler(HttpStatus.NOT_FOUND, exception.getMessage(), false, path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(LoanConflictException.class)
    public ResponseEntity<ErrorHandler> LoanConflictException(LoanConflictException exception,
                                                              WebRequest request) {
        String path = extractPath(request);
        ErrorHandler message = new ErrorHandler(HttpStatus.CONFLICT, exception.getMessage(), false, path);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    private String extractPath(WebRequest request) {
        if (request instanceof ServletWebRequest) {
            return ((ServletWebRequest) request).getRequest().getRequestURI();
        }
        return "";
    }
}
