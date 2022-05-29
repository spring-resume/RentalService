package pl.edu.pjwstk.rentalservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.ConnectException;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleNotFoundException() {
        return ResponseEntity.status(404).body("Nie znaleziono");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleInvalidInputMovieException() {
        return ResponseEntity.status(400).body("Nieprawidłowe dane wejściowe");
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> handleConnectionException() {
        return ResponseEntity.status(504).body("Brak połączenia z MovieService ");
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> handleInternalErrorServerException() {
        return ResponseEntity.status(502).body("internal error server");
    }


}
