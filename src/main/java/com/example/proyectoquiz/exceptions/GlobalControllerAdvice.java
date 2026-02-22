package com.example.proyectoquiz.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleCursoNotFound(
            RuntimeException ex, WebRequest request) {
        ExceptionBody body = new ExceptionBody(LocalDateTime.now(), HttpStatus.NOT_FOUND, ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PartidaNotFoundException.class)
    public ResponseEntity<?> handlePartidaNotFound(
            PartidaNotFoundException ex, WebRequest request) {
        ExceptionBody body = new ExceptionBody(LocalDateTime.now(), HttpStatus.NOT_FOUND, ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(
            UserNotFoundException ex, WebRequest request) {
        ExceptionBody body = new ExceptionBody(LocalDateTime.now(), HttpStatus.NOT_FOUND, ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<?> handleAuthException(
            AuthException ex, WebRequest request) {
        ExceptionBody body = new ExceptionBody(LocalDateTime.now(), HttpStatus.UNAUTHORIZED, ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<Object>(body, HttpStatus.UNAUTHORIZED);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        ExceptionBody myBody = new ExceptionBody(LocalDateTime.now(),
                status, ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI());
        return ResponseEntity.status(status).headers(headers).body(myBody);
    }

}

@AllArgsConstructor
@Getter
class ExceptionBody {
    private LocalDateTime timeStamp;
    private HttpStatusCode status;
    private String message;
    private String path;
}